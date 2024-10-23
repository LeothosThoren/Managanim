package com.thoren.manganimu.core.network.models.anime


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PageResponse(
    @SerialName("currentPage")
    val currentPage: Int,
    @SerialName("hasNextPage")
    val hasNextPage: Boolean
)