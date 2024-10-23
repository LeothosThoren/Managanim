package com.thoren.manganimu.core.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultResponse(
    @SerialName("id")
    val id: String,
    @SerialName("malId")
    val malId: Int,
    @SerialName("title")
    val title: TitleResponse,
    @SerialName("image")
    val image: String,
    @SerialName("trailer")
    val trailer: TrailerResponse,
    @SerialName("description")
    val description: String,
    @SerialName("status")
    val status: String,
    @SerialName("cover")
    val cover: String,
    @SerialName("rating")
    val rating: Int,
    @SerialName("releaseDate")
    val releaseDate: Int,
    @SerialName("genres")
    val genres: List<String>,
    @SerialName("totalEpisodes")
    val totalEpisodes: Int,
    @SerialName("duration")
    val duration: Int,
    @SerialName("type")
    val type: String
)