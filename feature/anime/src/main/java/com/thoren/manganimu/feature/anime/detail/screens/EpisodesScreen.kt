package com.thoren.manganimu.feature.anime.detail.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.thoren.manganimu.feature.anime.detail.DetailViewModel
import com.thoren.manganimu.feature.anime.detail.models.AnimeDetailUiState
import com.thoren.manganimu.feature.anime.detail.models.EpisodeItemUiModel

@Composable
internal fun EpisodesRoute(
    animeId: Int,
    viewModel: DetailViewModel = hiltViewModel<DetailViewModel>(key = animeId.toString()),
    modifier: Modifier = Modifier
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    EpisodesScreen(state = uiState.value, modifier = modifier)
}

@Composable
internal fun EpisodesScreen(
    state: AnimeDetailUiState,
    modifier: Modifier = Modifier
) {
    Scaffold { innerPadding ->
        when (state) {
            is AnimeDetailUiState.Loading -> LoadingScreen(
                modifier = modifier.padding(innerPadding),
            )

            is AnimeDetailUiState.Success -> {
                AnimeInfoScreen(
                    state = state,
                    modifier = modifier.padding(innerPadding)
                )
            }

            is AnimeDetailUiState.Error -> ErrorScreen(
                error = stringResource(state.message),
                modifier = modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
private fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Loading...")
    }
}

@Composable
private fun ErrorScreen(error: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Error: $error")
    }
}

@Composable
private fun AnimeInfoScreen(
    state: AnimeDetailUiState.Success,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Anime Screen for animeId: ${state.animeDetail.id}")
        Text(text = "Title: ${state.animeDetail.title}")
        EpisodeItemList(episodes = state.episodes)
    }
}

@Composable
private fun EpisodeItemList(episodes: List<EpisodeItemUiModel>, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn {
            items(episodes) { episode ->
                Text(text = "Episode: ${episode.title}")
                Text(text = "Description: ${episode.description}")
            }
        }
    }
}