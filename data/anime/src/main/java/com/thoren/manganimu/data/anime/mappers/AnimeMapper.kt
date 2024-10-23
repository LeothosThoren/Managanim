package com.thoren.manganimu.data.anime.mappers

import com.thoren.manganimu.core.models.AnimeItem
import com.thoren.manganimu.core.network.models.anime.ResultResponse

internal fun ResultResponse.toAnimeItem(): AnimeItem {
    return AnimeItem(
        id = id,
        title = title.english,
        image = image,
        description = description,
    )
}