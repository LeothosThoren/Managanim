package com.thoren.manganimu.feature.anime.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface AnimeGraph {
    @Serializable
    object Dashboard : AnimeGraph

    @Serializable
    data class Episodes(val id: Int) : AnimeGraph
}