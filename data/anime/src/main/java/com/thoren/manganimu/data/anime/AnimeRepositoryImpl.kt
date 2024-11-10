package com.thoren.manganimu.data.anime

import com.thoren.manganimu.common.IoDispatcher
import com.thoren.manganimu.common.ResultOf
import com.thoren.manganimu.common.mapFailure
import com.thoren.manganimu.common.mapSuccess
import com.thoren.manganimu.core.models.AnimeItem
import com.thoren.manganimu.core.models.EpisodeItem
import com.thoren.manganimu.core.network.extension.apiCall
import com.thoren.manganimu.core.network.networkdatasources.AnimeNetworkDataSource
import com.thoren.manganimu.data.anime.mappers.toAnimeItems
import com.thoren.manganimu.data.anime.mappers.toEpisodeItems
import com.thoren.manganimu.domain.anime.repositories.AnimeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.InternalSerializationApi
import javax.inject.Inject

internal class AnimeRepositoryImpl @Inject constructor(
    private val animeNetworkDataSource: AnimeNetworkDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : AnimeRepository {
    @OptIn(InternalSerializationApi::class)
    override suspend fun getPopularAnime(): ResultOf<List<AnimeItem>, Throwable> =
        withContext(ioDispatcher) {
            apiCall {
                animeNetworkDataSource.getPopularAnime()
            }.mapSuccess { popularAnimeResponses ->
                popularAnimeResponses.toAnimeItems()
            }
        }.mapFailure {
            it.throwable
        }

    override suspend fun getAnimeEpisodes(id: String): ResultOf<List<EpisodeItem>, Throwable> =
        withContext(ioDispatcher) {
            apiCall {
                animeNetworkDataSource.getAnimeEpisodes(id)
            }.mapSuccess { animeEpisodeResponse ->
                animeEpisodeResponse.toEpisodeItems()
            }.mapFailure {
                it.throwable
            }
        }
}
