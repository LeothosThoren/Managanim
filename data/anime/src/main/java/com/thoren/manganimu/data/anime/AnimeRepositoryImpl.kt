package com.thoren.manganimu.data.anime

import com.thoren.manganimu.common.IoDispatcher
import com.thoren.manganimu.common.ResultOf
import com.thoren.manganimu.common.mapFailure
import com.thoren.manganimu.common.mapSuccess
import com.thoren.manganimu.core.models.AnimeFailure
import com.thoren.manganimu.core.models.AnimeItem
import com.thoren.manganimu.core.models.EpisodeItem
import com.thoren.manganimu.core.network.extension.apiCall
import com.thoren.manganimu.core.network.networkdatasources.AnimeNetworkDataSource
import com.thoren.manganimu.data.anime.mappers.toAnimeFailure
import com.thoren.manganimu.data.anime.mappers.toAnimeItems
import com.thoren.manganimu.data.anime.mappers.toEpisodeItems
import com.thoren.manganimu.domain.anime.repositories.EpisodeRepository
import com.thoren.manganimu.domain.anime.repositories.PopularAnimeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class AnimeRepositoryImpl @Inject constructor(
    private val animeNetworkDataSource: AnimeNetworkDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : PopularAnimeRepository, EpisodeRepository {

    override suspend fun getPopularAnime(): ResultOf<List<AnimeItem>, AnimeFailure> =
        withContext(ioDispatcher) {
            apiCall {
                animeNetworkDataSource.getPopularAnime()
            }.mapSuccess { popularAnimeResponses ->
                popularAnimeResponses.toAnimeItems()
            }
        }.mapFailure {
            it.toAnimeFailure()
        }

    override suspend fun getAnimeEpisodes(id: String): ResultOf<List<EpisodeItem>, AnimeFailure> =
        withContext(ioDispatcher) {
            apiCall {
                animeNetworkDataSource.getAnimeEpisodes(id)
            }.mapSuccess { animeEpisodeResponse ->
                animeEpisodeResponse.toEpisodeItems()
            }.mapFailure {
                it.toAnimeFailure()
            }
        }
}
