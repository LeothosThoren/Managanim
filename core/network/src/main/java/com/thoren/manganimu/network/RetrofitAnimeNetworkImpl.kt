package com.thoren.manganimu.network.injection

import com.thoren.manganimu.network.injection.models.PopularAnimeResponse
import com.thoren.manganimu.network.injection.networkdatasources.AnimeNetworkDataSource
import com.thoren.manganimu.network.injection.services.AnimeApiService
import jakarta.inject.Inject

internal class RetrofitAnimeNetworkImpl @Inject constructor(
    private val animeApiService: AnimeApiService
) : AnimeNetworkDataSource {
    override suspend fun getPopularAnime(): List<PopularAnimeResponse> =
        animeApiService.getPopularAnime()
}