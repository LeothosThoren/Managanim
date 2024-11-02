package com.thoren.manganimu.core.network.models.anime


import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@InternalSerializationApi
@Serializable
data class CoverImageResponse(
    @SerialName("extraLarge")
    val extraLarge: String,
    @SerialName("large")
    val large: String,
    @SerialName("medium")
    val medium: String,
    @SerialName("color")
    val color: String? = null
)