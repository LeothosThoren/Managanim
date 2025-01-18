package com.thoren.manganimu.feature.anime.detail.models

import com.thoren.manganimu.core.models.AnimeDetail
import com.thoren.manganimu.core.models.AnimeItem

data class AnimeDetailUiModel(
    val id: Int,
    val idProvider: String,
    val title: String,
    val coverImage: AnimeItem.CoverImage,
    val description: String,
    val episodes: Int,
    val year: Int
)

internal fun AnimeDetail.toAnimeDetailUiModel() = AnimeDetailUiModel(
    id = id,
    idProvider = idProvider,
    title = title,
    coverImage = coverImage,
    description = description,
    episodes = episodes,
    year = year
)


