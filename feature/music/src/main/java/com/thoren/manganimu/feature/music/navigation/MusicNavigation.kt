package com.thoren.manganimu.feature.music.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val MUSIC_ROUTE = "music_route"

fun NavController.navigateToMusic(navOptions: NavOptions) = navigate(MUSIC_ROUTE, navOptions)

fun NavGraphBuilder.musicScreen() {
    composable(route = MUSIC_ROUTE) {
        Box(contentAlignment = Alignment.Center) { Text(text = "Music") }
    }
}
