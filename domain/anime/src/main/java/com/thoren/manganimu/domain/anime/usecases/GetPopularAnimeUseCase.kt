package com.thoren.manganimu.domain.anime.usecases

import com.thoren.manganimu.common.ResultOf
import com.thoren.manganimu.core.models.AnimeItem
import com.thoren.manganimu.domain.anime.repositories.AnimeRepository
import javax.inject.Inject

fun interface GetPopularAnimeUseCase {
    suspend operator fun invoke(): ResultOf<List<AnimeItem>, Throwable>
}

internal class GetPopularAnimeUseCaseImpl @Inject constructor(
    private val animeRepository: AnimeRepository
) : GetPopularAnimeUseCase {
    override suspend operator fun invoke(): ResultOf<List<AnimeItem>, Throwable> =
        animeRepository.getPopularAnime()
}