package com.thoren.manganimu.feature.anime.screens

import PreviewTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.thoren.manganimu.core.ui.common.SpaceSize
import com.thoren.manganimu.core.ui.component.BasicAnimeTile
import com.thoren.manganimu.feature.anime.DashboardViewModel
import com.thoren.manganimu.feature.anime.model.DashboardUiState
import com.thoren.manganimu.feature.anime.model.PopularAnimeUiModel
import kotlin.random.Random

@Composable
internal fun DashboardRoute(
    modifier: Modifier = Modifier,
    viewModel: DashboardViewModel = hiltViewModel<DashboardViewModel>(),
) {
    val state = viewModel.uiState.collectAsStateWithLifecycle()

    DashboardScreen(modifier = modifier, state = state.value)
}

@Composable
internal fun DashboardScreen(
    modifier: Modifier = Modifier,
    state: DashboardUiState
) {
    Scaffold { innerPaddings ->
        Box(
            modifier = modifier.padding(innerPaddings),
            contentAlignment = Alignment.Center
        ) {
            when (state) {
                is DashboardUiState.Loading -> {
                    Text(text = "Loading...")
                }

                is DashboardUiState.Success -> {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(SpaceSize.small),
                        contentPadding = PaddingValues(SpaceSize.small)
                    ) {
                        items(items = state.popularAnime, key = { it.id }) { anime ->
                            BasicAnimeTile(
                                title = anime.title,
                                imageUrl = anime.imageUrl
                            )
                        }
                    }
                }

                is DashboardUiState.Error -> {
                    Text(text = "Error")
                }
            }
        }

    }
}

@Composable
@PreviewLightDark
private fun DashboardScreenPreview() {
    PreviewTheme {
        DashboardScreen(
            state = DashboardUiState.Success(
                popularAnime = (1..10)
                    .map {
                        PopularAnimeUiModel(
                            id = it,
                            title = Random.nextLong().toString(),
                            imageUrl = "https://cdn.myanimelist.net/images/anime/13/17405.jpg"
                        )
                    }
            )
        )
    }
}