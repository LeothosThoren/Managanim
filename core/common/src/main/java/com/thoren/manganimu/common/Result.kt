package com.thoren.manganimu.common

sealed interface Result {
    data object Success
    data object Failure
}