package com.thoren.manganimu.core.network.models.anime


import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@InternalSerializationApi
@Serializable
data class PopularAnimeResponse(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("page")
    val page: PageResponse,
    @SerialName("results")
    val results: List<ResultResponse>
)