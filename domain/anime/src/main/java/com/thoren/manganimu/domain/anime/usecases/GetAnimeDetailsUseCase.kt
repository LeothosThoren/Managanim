package com.thoren.manganimu.domain.anime.usecases

import com.thoren.manganimu.common.ResultOf
import com.thoren.manganimu.core.models.AnimeDetail
import com.thoren.manganimu.core.models.AnimeFailure
import com.thoren.manganimu.domain.anime.repositories.AnimeDetailsRepository
import javax.inject.Inject

fun interface GetAnimeDetailsUseCase {
    suspend operator fun invoke(id: String): ResultOf<AnimeDetail, AnimeFailure>
}

internal class GetAnimeDetailsUseCaseImpl @Inject constructor(
    private val animeDetailsRepository: AnimeDetailsRepository
) : GetAnimeDetailsUseCase {
    override suspend operator fun invoke(id: String): ResultOf<AnimeDetail, AnimeFailure> =
        animeDetailsRepository.getAnimeDetails(id = id)
}