package com.thoren.manganimu.domain.anime.repositories

import com.thoren.manganimu.common.ResultOf
import com.thoren.manganimu.core.models.AnimeDetail
import com.thoren.manganimu.core.models.AnimeFailure

fun interface AnimeDetailsRepository {
    suspend fun getAnimeDetails(id: String): ResultOf<AnimeDetail, AnimeFailure>
}