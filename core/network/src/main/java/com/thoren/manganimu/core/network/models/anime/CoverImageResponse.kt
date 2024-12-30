package com.thoren.manganimu.core.network.models.anime


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoverImageResponse(
    @SerialName("extraLarge")
    val extraLarge: String? = null,
    @SerialName("large")
    val large: String? = null,
    @SerialName("medium")
    val medium: String? = null,
    @SerialName("color")
    val color: String? = null
)