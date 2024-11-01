package com.thoren.manganimu.feature.anime.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.thoren.manganimu.feature.anime.screens.DashboardRoute

const val DASHBOARD_ROUTE = "dashboard route"

fun NavController.navigateToAnime(navOptions: NavOptions) = navigate(DASHBOARD_ROUTE, navOptions)

fun NavGraphBuilder.animeScreen() {
    composable(route = DASHBOARD_ROUTE) {
        DashboardRoute()
    }
}