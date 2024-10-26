package com.thoren.manganimu.data.anime.mappers

import com.thoren.manganimu.core.models.AnimeItem
import com.thoren.manganimu.core.network.models.anime.PopularAnimeResponse
import com.thoren.manganimu.core.network.models.anime.ResultResponse

internal fun PopularAnimeResponse.toAnimeItems(): List<AnimeItem> = results.map { it.toAnimeItem() }

internal fun ResultResponse.toAnimeItem(): AnimeItem =
    AnimeItem(
        id = id,
        title = title.english,
        image = coverImage.medium,
    )
