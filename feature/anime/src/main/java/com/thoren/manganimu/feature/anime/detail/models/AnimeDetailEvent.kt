package com.thoren.manganimu.feature.anime.detail.models

internal sealed class AnimeDetailEvent {
    data class ReadEpisode(val episodeId: String, val episodeNbr: String) : AnimeDetailEvent()
}