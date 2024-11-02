package com.thoren.manganimu.core.network.models.anime


import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@InternalSerializationApi
@Serializable
data class PageResponse(
    @SerialName("total")
    val total: Int,
    @SerialName("perPage")
    val perPage: Int,
    @SerialName("currentPage")
    val currentPage: Int,
    @SerialName("lastPage")
    val lastPage: Int,
    @SerialName("hasNextPage")
    val hasNextPage: Boolean
)