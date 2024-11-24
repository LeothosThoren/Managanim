package com.thoren.manganimu.core.network.services

import com.thoren.manganimu.core.network.models.anime.AnimeDetailResponse
import com.thoren.manganimu.core.network.models.anime.AnimeEpisodeResponse
import com.thoren.manganimu.core.network.models.anime.PopularAnimeResponse
import retrofit2.http.GET
import retrofit2.http.Path

internal interface AnimeApiService {

    @GET("api/v2/popular")
    suspend fun getPopularAnime(): PopularAnimeResponse

    @GET("api/v2/episode/{id}")
    suspend fun getAnimeEpisodes(@Path("id") id: String): AnimeEpisodeResponse

    @GET("api/v2/info/{id}")
    suspend fun getAnimeDetails(@Path("id") id: String): AnimeDetailResponse
}