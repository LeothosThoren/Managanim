package com.thoren.manganimu.feature.anime.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.thoren.manganimu.core.navigation.ManganimuGraph
import com.thoren.manganimu.feature.anime.dashboard.screens.DashboardRoute
import com.thoren.manganimu.feature.anime.detail.screens.EpisodesRoute

fun NavController.navigateToAnime(navOptions: NavOptions) =
    navigate(route = ManganimuGraph.AnimeGraph.Dashboard, navOptions)

fun NavController.navigateToEpisodes(animeId: Int) =
    navigate(route = ManganimuGraph.AnimeGraph.Episodes(animeId))

/** Anime Graph **/
fun NavGraphBuilder.animeScreen(navController: NavController) {
    composable<ManganimuGraph.AnimeGraph.Dashboard> {
        DashboardRoute { animeId ->
            navController.navigateToEpisodes(animeId)
        }
    }

    composable<ManganimuGraph.AnimeGraph.Episodes> { entry ->
        val animeId = entry.toRoute<ManganimuGraph.AnimeGraph.Episodes>().id
        EpisodesRoute(animeId)
    }
}