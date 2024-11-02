package com.thoren.manganimu.core.network

import android.util.Log
import com.thoren.manganimu.core.network.models.anime.PopularAnimeResponse
import com.thoren.manganimu.core.network.networkdatasources.AnimeNetworkDataSource
import com.thoren.manganimu.core.network.services.AnimeApiService
import jakarta.inject.Inject
import kotlinx.serialization.InternalSerializationApi

@OptIn(InternalSerializationApi::class)
internal class RetrofitAnimeNetworkImpl @Inject constructor(
    private val animeApiService: AnimeApiService
) : AnimeNetworkDataSource {
    override suspend fun getPopularAnime(): PopularAnimeResponse {
        val response = animeApiService.getPopularAnime()
        Log.d("LOGGER_RetrofitAnimeNetworkImpl", "getPopularAnime: $response")
        return response
    }
}