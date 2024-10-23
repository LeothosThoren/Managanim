package com.thoren.manganimu.network.injection.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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