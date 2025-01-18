package com.thoren.manganimu.core.network.models.anime

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeEpisodeResponse(
    @SerialName("results") val episodes: List<EpisodeResponse>
)