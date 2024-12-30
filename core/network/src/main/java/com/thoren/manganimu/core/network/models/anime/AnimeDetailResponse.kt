package com.thoren.manganimu.core.network.models.anime


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeDetailResponse(
    @SerialName("bannerImage")
    val bannerImage: String,
    @SerialName("code")
    val code: Int? = null,
    @SerialName("coverImage")
    val coverImage: CoverImageResponse,
    @SerialName("description")
    val description: String,
    @SerialName("dub")
    val dub: Boolean,
    @SerialName("duration")
    val duration: Int? = null,
    @SerialName("episodes")
    val episodes: Int,
    @SerialName("format")
    val format: String,
    @SerialName("genres")
    val genres: List<String>,
    @SerialName("id")
    val id: Int,
    @SerialName("idMal")
    val idMal: Int,
    @SerialName("id_provider")
    val idProvider: IdProviderResponse,
    @SerialName("message")
    val message: String? = null,
    @SerialName("popularity")
    val popularity: Int? = null,
    @SerialName("relation")
    val relation: List<RelationResponse> = emptyList(),
    @SerialName("season")
    val season: String,
    @SerialName("status")
    val status: String,
    @SerialName("title")
    val title: TitleResponse,
    @SerialName("year")
    val year: Int
)