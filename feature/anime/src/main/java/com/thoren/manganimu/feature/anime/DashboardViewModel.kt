package com.thoren.manganimu.feature.anime

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thoren.manganimu.common.onFailure
import com.thoren.manganimu.common.onSuccess
import com.thoren.manganimu.domain.anime.usecases.GetPopularAnimeUseCase
import com.thoren.manganimu.feature.anime.model.DashboardUiState
import com.thoren.manganimu.feature.anime.model.toPopularAnimeUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class DashboardViewModel @Inject constructor(
    private val getPopularAnime: GetPopularAnimeUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(buildDefaultUiState())
    val uiState: StateFlow<DashboardUiState> = _uiState
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = DashboardUiState.Loading,
        )

    init {
        getPopularAnimeList()
    }


    private fun getPopularAnimeList() {
        viewModelScope.launch {
            getPopularAnime.invoke()
                .onSuccess { animeList ->
                    _uiState.update { state ->
                        (state as DashboardUiState.Success).copy(popularAnime = animeList.map {
                            it.toPopularAnimeUiModel()
                        })
                    }
                }.onFailure { failure ->
                    _uiState.update {
                        DashboardUiState.Error(failure.message ?: "Unknown error")
                    }
                }
        }
    }

    private fun buildDefaultUiState(): DashboardUiState {
        return DashboardUiState.Success(emptyList())
    }
}