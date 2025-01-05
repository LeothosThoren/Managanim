package com.thoren.manganimu.data.anime.mappers

import com.thoren.manganimu.core.models.AnimeDetail
import com.thoren.manganimu.core.models.AnimeFailure
import com.thoren.manganimu.core.models.AnimeItem
import com.thoren.manganimu.core.models.EpisodeItem
import com.thoren.manganimu.core.network.models.anime.AnimeDetailResponse
import com.thoren.manganimu.core.network.models.anime.AnimeEpisodeResponse
import com.thoren.manganimu.core.network.models.anime.EpisodeResponse
import com.thoren.manganimu.core.network.models.anime.PopularAnimeResponse
import com.thoren.manganimu.core.network.models.failure.ApiCallFailure
import com.thoren.manganimu.core.network.models.failure.HttpStatusCode

internal fun PopularAnimeResponse.toAnimeItems(): List<AnimeItem> = results.map { it.toAnimeItem() }

internal fun PopularAnimeResponse.ResultResponse.toAnimeItem(): AnimeItem =
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

internal fun AnimeDetailResponse.toAnimeDetail(): AnimeDetail =
    AnimeDetail(
        bannerImage = bannerImage,
        coverImage = AnimeItem.CoverImage(
            medium = coverImage.medium,
            large = coverImage.large,
            extraLarge = coverImage.extraLarge,
        ),
        description = description,
        dub = dub,
        episodes = episodes,
        format = format,
        genres = genres,
        id = id,
        idMal = idMal,
        idProvider = idProvider.idGogo,
        season = season,
        status = status,
        title = title.english,
        year = year
    )

internal fun ApiCallFailure.toAnimeFailure() =
    when (this) {
        is ApiCallFailure.IO,
        is ApiCallFailure.Timeout,
            -> AnimeFailure.Network

        is ApiCallFailure.Parsing,
        is ApiCallFailure.Unknown,
            -> AnimeFailure.Technical

        is ApiCallFailure.Http,
            -> when (code) {
            HttpStatusCode.BAD_REQUEST -> AnimeFailure.BadRequest
            HttpStatusCode.NOT_FOUND -> AnimeFailure.NotFound
            HttpStatusCode.TOO_MANY_REQUEST_CODE -> AnimeFailure.TooManyRequests
            HttpStatusCode.SERVER_ERROR -> AnimeFailure.ServerError
            else -> AnimeFailure.Technical
        }
    }