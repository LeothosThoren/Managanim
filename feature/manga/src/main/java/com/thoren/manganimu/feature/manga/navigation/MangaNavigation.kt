package com.thoren.manganimu.feature.manga.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val MANGA_ROUTE = "manga_route"

fun NavController.navigateToManga(navOptions: NavOptions) = navigate(MANGA_ROUTE, navOptions)

fun NavGraphBuilder.mangaScreen() {
    composable(route = MANGA_ROUTE) {
        Box(contentAlignment = Alignment.Center) { Text(text = "Manga") }
    }
}
