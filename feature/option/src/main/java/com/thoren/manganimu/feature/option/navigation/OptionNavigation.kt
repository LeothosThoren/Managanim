package com.thoren.manganimu.feature.option.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.thoren.manganimu.core.navigation.ManganimuGraph


fun NavController.navigateToOption(navOptions: NavOptions) =
    navigate(route = ManganimuGraph.OptionGraph.Settings, navOptions)

fun NavGraphBuilder.optionScreen() {
    composable<ManganimuGraph.OptionGraph.Settings> {
        Box(contentAlignment = Alignment.Center) { Text(text = "Option") }
    }
}
