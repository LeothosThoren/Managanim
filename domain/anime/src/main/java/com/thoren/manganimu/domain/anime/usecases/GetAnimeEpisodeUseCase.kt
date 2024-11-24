package com.thoren.manganimu.domain.anime.usecases

import com.thoren.manganimu.common.ResultOf
import com.thoren.manganimu.core.models.EpisodeItem
import com.thoren.manganimu.domain.anime.repositories.EpisodeRepository
import javax.inject.Inject


fun interface GetAnimeEpisodeUseCase {
    suspend operator fun invoke(id: String): ResultOf<List<EpisodeItem>, Throwable>
}

internal class GetAnimeEpisodeUseCaseImpl @Inject constructor(
    private val episodeRepository: EpisodeRepository
) : GetAnimeEpisodeUseCase {
    override suspend fun invoke(id: String): ResultOf<List<EpisodeItem>, Throwable> =
        episodeRepository.getAnimeEpisodes(id)
}