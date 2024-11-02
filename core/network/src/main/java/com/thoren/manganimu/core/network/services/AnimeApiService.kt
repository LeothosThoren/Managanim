package com.thoren.manganimu.core.network.services

import com.thoren.manganimu.core.network.models.anime.PopularAnimeResponse
import kotlinx.serialization.InternalSerializationApi
import retrofit2.http.GET

@OptIn(InternalSerializationApi::class)
internal interface AnimeApiService {

    @GET("api/v2/popular")
    suspend fun getPopularAnime(): PopularAnimeResponse
}