package com.thoren.manganimu.feature.manga.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.thoren.manganimu.core.navigation.ManganimuGraph

fun NavController.navigateToManga(navOptions: NavOptions) =
    navigate(ManganimuGraph.MangaGraph.Dashboard, navOptions)

fun NavGraphBuilder.mangaScreen() {
    composable<ManganimuGraph.MangaGraph.Dashboard> {
        Box(contentAlignment = Alignment.Center) { Text(text = "Manga") }
    }
}
