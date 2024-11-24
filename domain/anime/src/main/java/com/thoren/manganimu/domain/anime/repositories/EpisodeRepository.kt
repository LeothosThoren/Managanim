package com.thoren.manganimu.domain.anime.repositories

import com.thoren.manganimu.common.ResultOf
import com.thoren.manganimu.core.models.EpisodeItem

fun interface EpisodeRepository {
    suspend fun getAnimeEpisodes(id: String): ResultOf<List<EpisodeItem>, Throwable>
}