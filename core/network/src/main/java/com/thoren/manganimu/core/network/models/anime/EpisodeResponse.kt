package com.thoren.manganimu.core.network.models.anime

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpisodeResponse(
    @SerialName("id") val id: String,
    @SerialName("title") val title: String,
    @SerialName("description") val description: String?,
    @SerialName("number") val number: Int,
    @SerialName("image") val image: String
)