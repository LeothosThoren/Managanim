package com.thoren.manganimu.core.models

data class AnimeDetail(
    val bannerImage: String,
    val coverImage: AnimeItem.CoverImage,
    val description: String,
    val dub: Boolean,
    val episodes: Int,
    val format: String,
    val genres: List<String>,
    val id: Int,
    val idMal: Int,
    val idProvider: String,
    val season: String,
    val status: String,
    val title: String,
    val year: Int
)