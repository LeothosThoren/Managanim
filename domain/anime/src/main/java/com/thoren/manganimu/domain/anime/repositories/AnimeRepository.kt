package com.thoren.manganimu.domain.anime.repositories

import com.thoren.manganimu.common.ResultOf
import com.thoren.manganimu.core.models.AnimeItem

interface AnimeRepository {
    suspend fun getPopularAnime(): ResultOf<List<AnimeItem>, Throwable>
}