package com.thoren.manganimu.network.injection.services

import com.thoren.manganimu.network.injection.models.PopularAnimeResponse
import retrofit2.http.GET

internal interface AnimeApiService {

    @GET("api/v2/popular")
    suspend fun getPopularAnime(): List<PopularAnimeResponse>
}