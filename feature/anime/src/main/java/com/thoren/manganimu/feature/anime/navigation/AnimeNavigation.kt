package com.thoren.manganimu.feature.anime.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.thoren.manganimu.feature.anime.screens.DashboardScreen

const val ANIME_ROUTE = "anime_route"

fun NavController.navigateToAnime(navOptions: NavOptions) = navigate(ANIME_ROUTE, navOptions)

fun NavGraphBuilder.animeScreen() {
    composable(route = ANIME_ROUTE) {
        DashboardScreen()
    }
}