package com.thoren.manganimu.network.injection.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularAnimeResponse(
    @SerialName("status")
    val status: Int,
    @SerialName("page")
    val page: PageResponse,
    @SerialName("results")
    val results: List<ResultResponse>
)