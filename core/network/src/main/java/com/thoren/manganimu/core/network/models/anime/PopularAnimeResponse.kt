package com.thoren.manganimu.core.network.models.anime


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularAnimeResponse(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("page")
    val page: PageResponse,
    @SerialName("results")
    val results: List<ResultResponse>
) {


    @Serializable
    data class ResultResponse(
        @SerialName("id")
        val id: Int,
        @SerialName("idMal")
        val idMal: Int,
        @SerialName("status")
        val status: String,
        @SerialName("title")
        val title: TitleResponse,
        @SerialName("format")
        val format: String,
        @SerialName("bannerImage")
        val bannerImage: String,
        @SerialName("coverImage")
        val coverImage: CoverImageResponse,
        @SerialName("episodes")
        val episodes: Int? = null,
        @SerialName("seasonYear")
        val seasonYear: Int? = null,
    )
}