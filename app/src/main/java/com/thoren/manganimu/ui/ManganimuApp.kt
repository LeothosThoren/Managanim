package com.thoren.manganimu.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.thoren.manganimu.navigation.ManganimuNavHost
import com.thoren.manganimu.navigation.TopLevelDestination

@Composable
internal fun ManganimuApp(
    modifier: Modifier = Modifier,
    appState: ManganimuAppState = rememberManganimuAppState(),
) {
    val currentDestination = appState.currentDestination

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
        tonalElevation = 4.dp
    ) {
        NavigationSuiteScaffold(
            navigationSuiteItems = {
                appState.topLevelDestinations.forEach { destination ->
                    val selected = currentDestination
                        .isTopLevelDestinationInHierarchy(destination)

                    item(
                        selected = selected,
                        icon = {
                            Icon(
                                imageVector = if (selected) destination.selectedIcon else destination.unselectedIcon,
                                contentDescription = null
                            )
                        },
                        onClick = { appState.navigateToTopLevelDestination(destination) },
                    )
                }
            },
            modifier = modifier,
        ) {
            ManganimuNavHost(navHostController = appState.navController)
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) == true
    } == true