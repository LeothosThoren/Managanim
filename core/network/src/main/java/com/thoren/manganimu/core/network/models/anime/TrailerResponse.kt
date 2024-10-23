package com.thoren.manganimu.core.network.models.anime


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrailerResponse(
    @SerialName("id")
    val id: String,
    @SerialName("site")
    val site: String,
    @SerialName("thumbnail")
    val thumbnail: String
)