package com.thoren.manganimu.feature.anime.dashboard.model

import androidx.annotation.StringRes

internal sealed class DashboardUiState {
    data object Loading : DashboardUiState()
    data class Success(val popularAnime: List<PopularAnimeUiModel>) : DashboardUiState()
    data class Error(@StringRes val message: Int) : DashboardUiState()
}