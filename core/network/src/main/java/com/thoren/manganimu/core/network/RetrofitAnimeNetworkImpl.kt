package com.thoren.manganimu.core.network

import com.thoren.manganimu.core.network.models.anime.ResultResponse
import com.thoren.manganimu.core.network.networkdatasources.AnimeNetworkDataSource
import com.thoren.manganimu.core.network.services.AnimeApiService
import jakarta.inject.Inject

internal class RetrofitAnimeNetworkImpl @Inject constructor(
    private val animeApiService: AnimeApiService
) : AnimeNetworkDataSource {
    override suspend fun getPopularAnime(): List<ResultResponse> =
        animeApiService.getPopularAnime()
}