package com.thoren.manganimu.core.network.models.anime.stream


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VideoStreamResponse(
    @SerialName("info")
    val info: InfoResponse,
    @SerialName("stream")
    val stream: StreamResponse,
)