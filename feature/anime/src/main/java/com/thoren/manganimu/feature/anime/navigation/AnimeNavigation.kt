package com.thoren.manganimu.feature.anime.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.thoren.manganimu.feature.anime.screens.DashboardRoute
import com.thoren.manganimu.feature.anime.screens.EpisodesRoute

fun NavController.navigateToAnime(navOptions: NavOptions) =
    navigate(route = AnimeGraph.Dashboard, navOptions)

fun NavController.navigateToEpisodes(animeId: Int) = navigate(route = AnimeGraph.Episodes(animeId))

/** Anime Graph **/
fun NavGraphBuilder.animeScreen(navController: NavController) {
    composable<AnimeGraph.Dashboard> {
        DashboardRoute { animeId ->
            navController.navigateToEpisodes(animeId)
        }
    }

    composable<AnimeGraph.Episodes> { entry ->
        val animeId = entry.toRoute<AnimeGraph.Episodes>().id
        EpisodesRoute(animeId)
    }
}