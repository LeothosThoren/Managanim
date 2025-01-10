package com.thoren.manganimu.domain.anime.repositories

import com.thoren.manganimu.common.ResultOf
import com.thoren.manganimu.core.models.AnimeFailure
import com.thoren.manganimu.core.models.AnimeStream

fun interface StreamAnimeRepository {
    suspend fun getStreamAnime(
        episodeId: String,
        episodeNbr: String
    ): ResultOf<AnimeStream, AnimeFailure>
}