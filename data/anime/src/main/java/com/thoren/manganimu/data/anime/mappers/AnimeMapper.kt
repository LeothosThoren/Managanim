package com.thoren.manganimu.data.anime.mappers

import com.thoren.manganimu.core.models.AnimeItem
import com.thoren.manganimu.core.models.EpisodeItem
import com.thoren.manganimu.core.network.models.anime.AnimeEpisodeResponse
import com.thoren.manganimu.core.network.models.anime.EpisodeResponse
import com.thoren.manganimu.core.network.models.anime.PopularAnimeResponse
import com.thoren.manganimu.core.network.models.anime.ResultResponse

internal fun PopularAnimeResponse.toAnimeItems(): List<AnimeItem> = results.map { it.toAnimeItem() }

internal fun ResultResponse.toAnimeItem(): AnimeItem =
    AnimeItem(
        id = id,
        title = title.english,
        coverImage = AnimeItem.CoverImage(
            medium = coverImage.medium,
            large = coverImage.large,
            extraLarge = coverImage.extraLarge,
        )
    )
internal fun AnimeEpisodeResponse.toEpisodeItems(): List<EpisodeItem> =
    episodes.map { it.toEpisodeItem() }

internal fun EpisodeResponse.toEpisodeItem(): EpisodeItem =
    EpisodeItem(
        id = id,
        title = title,
        description = description,
        number = number,
        image = image
    )