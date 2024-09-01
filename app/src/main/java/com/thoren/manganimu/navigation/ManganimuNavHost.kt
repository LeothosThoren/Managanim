package com.thoren.manganimu.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.thoren.manganimu.feature.anime.navigation.ANIME_ROUTE
import com.thoren.manganimu.feature.anime.navigation.animeScreen
import com.thoren.manganimu.feature.manga.navigation.mangaScreen
import com.thoren.manganimu.feature.music.navigation.musicScreen
import com.thoren.manganimu.feature.option.navigation.optionScreen

@Composable
fun ManganimuNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    startDestination: String = ANIME_ROUTE,
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        animeScreen()
        mangaScreen()
        musicScreen()
        optionScreen()
    }
}