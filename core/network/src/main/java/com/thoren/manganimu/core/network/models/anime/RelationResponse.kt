package com.thoren.manganimu.core.network.models.anime


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RelationResponse(
    @SerialName("averageScore")
    val averageScore: Int,
    @SerialName("bannerImage")
    val bannerImage: String?,
    @SerialName("coverImage")
    val coverImage: CoverImageResponse,
    @SerialName("duration")
    val duration: Int?,
    @SerialName("episodes")
    val episodes: Int?,
    @SerialName("format")
    val format: String,
    @SerialName("genres")
    val genres: List<String>,
    @SerialName("id")
    val id: Int,
    @SerialName("idMal")
    val idMal: Int,
    @SerialName("season")
    val season: String?,
    @SerialName("status")
    val status: String,
    @SerialName("title")
    val title: TitleResponse,
    @SerialName("type")
    val type: String
)