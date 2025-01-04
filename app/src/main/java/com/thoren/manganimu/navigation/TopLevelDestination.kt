package com.thoren.manganimu.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.thoren.manganimu.core.navigation.ManganimuGraph
import com.thoren.manganimu.feature.anime.R as animeR
import com.thoren.manganimu.feature.manga.R as mangaR
import com.thoren.manganimu.feature.music.R as musicR
import com.thoren.manganimu.feature.option.R as optionR


enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val titleTextId: Int,
    val graphRoute: ManganimuGraph
) {
    ANIME(
        Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        titleTextId = animeR.string.feature_anime_title,
        graphRoute = ManganimuGraph.AnimeGraph.Dashboard,
    ),
    MANGA(
        selectedIcon = Icons.Filled.Menu,
        unselectedIcon = Icons.Outlined.Menu,
        titleTextId = mangaR.string.feature_manga_title,
        graphRoute = ManganimuGraph.MangaGraph.Dashboard,
    ),
    MUSIC(
        selectedIcon = Icons.Filled.PlayArrow,
        unselectedIcon = Icons.Outlined.PlayArrow,
        titleTextId = musicR.string.feature_music_title,
        graphRoute = ManganimuGraph.MusicGraph.Dashboard,
    ),
    OPTION(
        selectedIcon = Icons.Default.Settings,
        unselectedIcon = Icons.Outlined.Settings,
        titleTextId = optionR.string.feature_option_title,
        graphRoute = ManganimuGraph.OptionGraph.Settings,
    ),
}