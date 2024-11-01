package com.thoren.manganimu.core.models

data class AnimeItem(
    val id: Int,
    val title: String,
    val coverImage: CoverImage,
) {
    data class CoverImage(
        val medium: String,
        val large: String,
        val extraLarge: String,
    )
}
