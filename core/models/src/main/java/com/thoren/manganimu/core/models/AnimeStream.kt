package com.thoren.manganimu.core.models

data class AnimeStream(
    val id: String,
    val title: String,
    val episode: String,
    val main: StreamDetail,
    val backup: StreamDetail
) {
    data class StreamDetail(
        val url: String,
        val isM3U8: Boolean,
        val quality: String
    )
}