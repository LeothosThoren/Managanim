package com.thoren.manganimu.feature.anime.dashboard.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun EpisodesRoute(id: Int) {
    EpisodesScreen(animeId = id)
}

@Composable
internal fun EpisodesScreen(modifier: Modifier = Modifier, animeId: Int) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Episodes Screen for animeId: $animeId")
    }
}