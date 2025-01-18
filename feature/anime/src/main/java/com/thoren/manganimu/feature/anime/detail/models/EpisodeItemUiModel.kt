package com.thoren.manganimu.feature.anime.detail.models

import com.thoren.manganimu.core.models.EpisodeItem

data class EpisodeItemUiModel(
    val id: String,
    val title: String,
    val description: String?,
    val number: Int,
    val image: String
)

internal fun EpisodeItem.toEpisodeItemUiModel() = EpisodeItemUiModel(
    id = id,
    title = title,
    description = description,
    number = number,
    image = image
)