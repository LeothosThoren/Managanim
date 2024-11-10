package com.thoren.manganimu.domain.anime.repositories

import com.thoren.manganimu.common.ResultOf
import com.thoren.manganimu.core.models.AnimeItem
import com.thoren.manganimu.core.models.EpisodeItem

interface AnimeRepository {
    suspend fun getPopularAnime(): ResultOf<List<AnimeItem>, Throwable>
    suspend fun getAnimeEpisodes(id: String): ResultOf<List<EpisodeItem>, Throwable>
}