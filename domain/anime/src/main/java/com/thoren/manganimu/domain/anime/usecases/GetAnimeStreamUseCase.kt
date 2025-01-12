package com.thoren.manganimu.domain.anime.usecases

import com.thoren.manganimu.common.ResultOf
import com.thoren.manganimu.core.models.AnimeFailure
import com.thoren.manganimu.core.models.AnimeStream
import com.thoren.manganimu.domain.anime.repositories.StreamAnimeRepository
import javax.inject.Inject

fun interface GetAnimeStreamUseCase {
    suspend operator fun invoke(
        episodeId: String,
        episodeNbr: String
    ): ResultOf<AnimeStream, AnimeFailure>
}

internal class GetAnimeStreamUseCaseImpl @Inject constructor(
    private val streamAnimeRepository: StreamAnimeRepository
) : GetAnimeStreamUseCase {
    override suspend fun invoke(
        episodeId: String,
        episodeNbr: String
    ): ResultOf<AnimeStream, AnimeFailure> =
        streamAnimeRepository.getStreamAnime(episodeId = episodeId, episodeNbr = episodeNbr)
}