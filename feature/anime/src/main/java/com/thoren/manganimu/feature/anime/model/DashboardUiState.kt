package com.thoren.manganimu.feature.anime.model

internal sealed class DashboardUiState {
    data object Loading : DashboardUiState()
    data class Success(val popularAnime: List<PopularAnimeUiModel>) : DashboardUiState()
    data class Error(val message: String) : DashboardUiState()
}