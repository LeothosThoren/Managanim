package com.thoren.manganimu.core.network.models.anime


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IdProviderResponse(
    @SerialName("idGogo")
    val idGogo: String,
    @SerialName("idPahe")
    val idPahe: String,
    @SerialName("idZoro")
    val idZoro: String
)