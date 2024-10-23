package com.thoren.manganimu.network.injection.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PageResponse(
    @SerialName("currentPage")
    val currentPage: Int,
    @SerialName("hasNextPage")
    val hasNextPage: Boolean
)