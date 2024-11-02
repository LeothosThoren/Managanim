package com.thoren.manganimu.core.network.models.anime


import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@InternalSerializationApi
@Serializable
data class InfoResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("idMal")
    val idMal: Int,
    @SerialName("title")
    val title: TitleResponse
)