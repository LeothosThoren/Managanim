package com.thoren.manganimu.core.models

sealed interface AnimeFailure {
    data object Network : AnimeFailure
    data object Technical : AnimeFailure
    data object NotFound : AnimeFailure
    data object BadRequest : AnimeFailure
    data object TooManyRequests : AnimeFailure
    data object ServerError : AnimeFailure
}