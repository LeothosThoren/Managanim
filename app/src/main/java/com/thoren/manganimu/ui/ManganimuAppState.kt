package com.thoren.manganimu.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.thoren.manganimu.feature.anime.navigation.navigateToAnime
import com.thoren.manganimu.feature.manga.navigation.navigateToManga
import com.thoren.manganimu.feature.music.navigation.navigateToMusic
import com.thoren.manganimu.feature.option.navigation.navigateToOption
import com.thoren.manganimu.navigation.TopLevelDestination

@Composable
internal fun rememberManganimuAppState(
    navController: NavHostController = rememberNavController(),
): ManganimuAppState {
    return remember(navController) {
        ManganimuAppState(
            navController = navController
        )
    }
}

@Stable
internal class ManganimuAppState(
    val navController: NavHostController,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.entries

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (topLevelDestination) {
            TopLevelDestination.ANIME -> navController.navigateToAnime(topLevelNavOptions)
            TopLevelDestination.MANGA -> navController.navigateToManga(topLevelNavOptions)
            TopLevelDestination.MUSIC -> navController.navigateToMusic(topLevelNavOptions)
            TopLevelDestination.OPTION -> navController.navigateToOption(topLevelNavOptions)
        }
    }
}