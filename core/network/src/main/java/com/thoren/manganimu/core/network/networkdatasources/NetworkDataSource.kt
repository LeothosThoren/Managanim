package com.thoren.manganimu.core.network.networkdatasources

import com.thoren.manganimu.core.network.models.anime.AnimeDetailResponse
import com.thoren.manganimu.core.network.models.anime.AnimeEpisodeResponse
import com.thoren.manganimu.core.network.models.anime.PopularAnimeResponse

interface AnimeNetworkDataSource {

    //    suspend fun getRecentEpisodes(): List<RecentEpisode> // https://api.amvstr.me/api/v1/recentepisode/sub
//
    suspend fun getPopularAnime(): PopularAnimeResponse // https://api.amvstr.me/api/v2/popular/all

    //
//    fun getStreamingLinks(): List<StreamingLink> // https://api.amvstr.me/api/v2/stream
//
//    suspend fun getStreamSkipTimes(): List<StreamSkipTimes> // https://api.amvstr.me/api/v2/stream/skiptime/{AnhilistId}/{ep_id}
//
//    suspend fun downloadEpisode(id: String): DownloadEpisode // https://api.amvstr.me/api/v1/download/{id}
//
//    suspend fun getMovies(): List<Movies>  // https://api.amvstr.me/api/v1/movies
//
//    suspend fun searchAnime(query: String): List<SearchAnime> // https://api.amvstr.me/api/v2/search?q=query&limit=10
//
    suspend fun getAnimeEpisodes(id: String): AnimeEpisodeResponse // https://api.amvstr.me/api/v2/episode/id

    suspend fun getAnimeDetails(id: String): AnimeDetailResponse // https://api.amvstr.me/api/v2/infp/id
//
//    suspend fun getAnimeGenres(): List<String> // https://api.amvstr.me/api/v1/genres
//
//    suspend fun getAnimeByGenre(genre: String): List<AnimeByGenre> // https://api.amvstr.me/api/v2/genres/genreID

}
