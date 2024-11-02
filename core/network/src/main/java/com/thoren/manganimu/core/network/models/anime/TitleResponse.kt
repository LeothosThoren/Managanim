package com.thoren.manganimu.core.network.models.anime


import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@InternalSerializationApi
@Serializable
data class TitleResponse(
    @SerialName("romaji")
    val romaji: String,
    @SerialName("english")
    val english: String,
    @SerialName("native")
    val native: String,
    @SerialName("userPreferred")
    val userPreferred: String
)