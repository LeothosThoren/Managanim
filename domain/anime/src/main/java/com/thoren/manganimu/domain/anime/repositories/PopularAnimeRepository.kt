package com.thoren.manganimu.domain.anime.repositories

import com.thoren.manganimu.common.ResultOf
import com.thoren.manganimu.core.models.AnimeFailure
import com.thoren.manganimu.core.models.AnimeItem

fun interface PopularAnimeRepository {
    suspend fun getPopularAnime(): ResultOf<List<AnimeItem>, AnimeFailure>
}