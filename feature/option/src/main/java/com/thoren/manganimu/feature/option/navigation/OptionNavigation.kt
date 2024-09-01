package com.thoren.manganimu.feature.option.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val OPTION_ROUTE = "option_route"

fun NavController.navigateToOption(navOptions: NavOptions) = navigate(OPTION_ROUTE, navOptions)

fun NavGraphBuilder.optionScreen() {
    composable(route = OPTION_ROUTE) {
        Box(contentAlignment = Alignment.Center) { Text(text = "Option") }
    }
}
