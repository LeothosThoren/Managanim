package com.thoren.manganimu.feature.anime.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.thoren.manganimu.feature.anime.DashboardViewModel
import com.thoren.manganimu.feature.anime.model.DashboardUiState

@Composable
internal fun DashboardScreen(
    modifier: Modifier = Modifier,
    viewModel: DashboardViewModel = hiltViewModel()
) {
    val state = viewModel.uiState.collectAsStateWithLifecycle()

    Box(contentAlignment = Alignment.Center) {
        when (val uiState = state.value) {
            is DashboardUiState.Loading -> {
                Text(text = "Loading...")
            }

            is DashboardUiState.Success -> {
                LazyColumn {
                    items(items = uiState.popularAnime, key = { it.id }) { anime ->
                        Text(text = anime.title)
                    }
                    item { Text(text = "Success") }
                }
            }

            is DashboardUiState.Error -> {
                Text(text = "Error")
            }
        }
    }
}