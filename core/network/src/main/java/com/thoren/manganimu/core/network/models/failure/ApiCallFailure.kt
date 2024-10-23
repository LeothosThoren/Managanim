package com.thoren.manganimu.core.network.models.failure

import java.io.IOException
import java.util.concurrent.TimeoutException

sealed class ApiCallFailure {
    abstract val throwable: Throwable

    data class Http(override val throwable: retrofit2.HttpException, val code: Int) :
        ApiCallFailure()

    data class Parsing(override val throwable: Throwable) : ApiCallFailure()
    data class IO(override val throwable: IOException) : ApiCallFailure()
    data class Timeout(override val throwable: TimeoutException) : ApiCallFailure()
    data class Unknown(override val throwable: Throwable) : ApiCallFailure()
}