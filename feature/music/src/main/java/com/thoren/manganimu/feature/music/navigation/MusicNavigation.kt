package com.thoren.manganimu.feature.music.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.thoren.manganimu.core.navigation.ManganimuGraph

fun NavController.navigateToMusic(navOptions: NavOptions) =
    navigate(ManganimuGraph.MusicGraph.Dashboard, navOptions)

fun NavGraphBuilder.musicScreen() {
    composable<ManganimuGraph.MusicGraph.Dashboard> {
        Box(contentAlignment = Alignment.Center) { Text(text = "Music") }
    }
}
