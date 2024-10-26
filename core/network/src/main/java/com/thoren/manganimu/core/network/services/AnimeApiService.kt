package com.thoren.manganimu.core.network.services

import com.thoren.manganimu.core.network.models.anime.PopularAnimeResponse
import retrofit2.http.GET

internal interface AnimeApiService {

    @GET("api/v2/popular")
    suspend fun getPopularAnime(): PopularAnimeResponse
}