package com.thoren.manganimu.domain.anime.usecases

import com.thoren.manganimu.common.ResultOf
import com.thoren.manganimu.core.models.AnimeItem
import com.thoren.manganimu.domain.anime.repositories.PopularAnimeRepository
import javax.inject.Inject

fun interface GetPopularAnimeUseCase {
    suspend operator fun invoke(): ResultOf<List<AnimeItem>, Throwable>
}

internal class GetPopularAnimeUseCaseImpl @Inject constructor(
    private val popularAnimeRepository: PopularAnimeRepository
) : GetPopularAnimeUseCase {
    override suspend operator fun invoke(): ResultOf<List<AnimeItem>, Throwable> =
        popularAnimeRepository.getPopularAnime()
}