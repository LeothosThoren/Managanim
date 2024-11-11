package com.thoren.manganimu.domain.anime.usecases

import com.thoren.manganimu.common.ResultOf
import com.thoren.manganimu.core.models.EpisodeItem
import com.thoren.manganimu.domain.anime.repositories.AnimeRepository
import javax.inject.Inject


fun interface GetAnimeEpisodeUseCase {
    suspend operator fun invoke(id: String): ResultOf<List<EpisodeItem>, Throwable>
}

internal class GetAnimeEpisodeUseCaseImpl @Inject constructor(
    private val animeRepository: AnimeRepository
) : GetAnimeEpisodeUseCase {
    override suspend fun invoke(id: String): ResultOf<List<EpisodeItem>, Throwable> =
        animeRepository.getAnimeEpisodes(id)
}