package com.thoren.manganimu.core.network

import com.thoren.manganimu.core.network.models.PopularAnimeResponse
import com.thoren.manganimu.core.network.networkdatasources.AnimeNetworkDataSource
import com.thoren.manganimu.core.network.services.AnimeApiService
import jakarta.inject.Inject

internal class RetrofitAnimeNetworkImpl @Inject constructor(
    private val animeApiService: AnimeApiService
) : AnimeNetworkDataSource {
    override suspend fun getPopularAnime(): List<PopularAnimeResponse> =
        animeApiService.getPopularAnime()
}