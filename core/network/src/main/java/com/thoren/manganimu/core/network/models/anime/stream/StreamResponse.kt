package com.thoren.manganimu.core.network.models.anime.stream


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StreamResponse(
    @SerialName("multi")
    val multi: MultiResponse,
    @SerialName("tracks")
    val tracks: String? = null
) {
    @Serializable
    data class MultiResponse(
        @SerialName("main")
        val main: StreamDetailResponse,
        @SerialName("backup")
        val backup: StreamDetailResponse
    ) {
        @Serializable
        data class StreamDetailResponse(
            @SerialName("url")
            val url: String,
            @SerialName("isM3U8")
            val isM3U8: Boolean,
            @SerialName("quality")
            val quality: String
        )
    }
}