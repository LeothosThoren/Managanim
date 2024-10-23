package com.thoren.manganimu.core.network.extension

import com.thoren.manganimu.common.ResultOf
import com.thoren.manganimu.common.mapFailure
import com.thoren.manganimu.common.throwIf
import com.thoren.manganimu.core.network.models.failure.ApiCallFailure
import kotlinx.serialization.SerializationException
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.CancellationException
import java.util.concurrent.TimeoutException


inline fun <reified S> apiCall(call: () -> S): ResultOf<S, ApiCallFailure> =
    ResultOf(call).throwIfCancelled().mapFailure { it.toApiCallFailure() }

inline fun <S, reified F : Throwable> ResultOf<S, F>.throwIfCancelled(): ResultOf<S, F> =
    throwIf { it is CancellationException }

fun Throwable.toApiCallFailure(): ApiCallFailure = when (this) {
    is HttpException -> ApiCallFailure.Http(this, this.code())
    is SerializationException -> ApiCallFailure.Parsing(this)
    is IOException -> ApiCallFailure.IO(this)
    is TimeoutException -> ApiCallFailure.Timeout(this)
    else -> ApiCallFailure.Unknown(this)
}