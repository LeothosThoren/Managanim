package com.thoren.manganimu.core.network.models.anime.stream


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfoResponse(
    @SerialName("title")
    val title: String,
    @SerialName("id")
    val id: String,
    @SerialName("episode")
    val episode: String
)