package com.thoren.manganimu.feature.anime.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val ANIME_ROUTE = "anime_route"

fun NavController.navigateToAnime(navOptions: NavOptions) = navigate(ANIME_ROUTE, navOptions)

fun NavGraphBuilder.animeScreen() {
    composable(route = ANIME_ROUTE) {
        Box(contentAlignment = Alignment.Center) { Text(text = "Anime") }
    }
}