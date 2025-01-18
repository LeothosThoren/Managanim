package com.thoren.manganimu.feature.anime.detail.models

import androidx.annotation.StringRes

internal sealed interface AnimeDetailUiState {

    data object Loading : AnimeDetailUiState

    data class Error(@StringRes val message: Int) : AnimeDetailUiState

    data class Success(
        val animeDetail: AnimeDetailUiModel,
        val episodes: List<EpisodeItemUiModel>,
    ) : AnimeDetailUiState
}