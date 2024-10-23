package com.thoren.manganimu.common

sealed class ResultOf<out S, out F> {
    abstract val value: Any?

    data class Success<out S>(override val value: S) : ResultOf<S, Nothing>()
    data class Failure<out F>(override val value: F) : ResultOf<Nothing, F>()

    val isSuccess: Boolean get() = this is Success<*>
    val isFailure: Boolean get() = this is Failure<*>

    companion object {

        inline operator fun <reified S> invoke(block: () -> S): ResultOf<S, Throwable> = try {
            Success(block())
        } catch (e: Throwable) {
            Failure(e)
        }

        inline fun <reified S> success(value: S): Success<S> = Success(value)

        inline fun <reified F> failure(value: F): Failure<F> = Failure(value)
    }
}

inline fun <S1, S2, F1> ResultOf<S1, F1>.fold(
    onSuccess: (S1) -> S2,
    onFailure: (F1) -> S2,
): S2 = when (this) {
    is ResultOf.Success -> onSuccess(value)
    is ResultOf.Failure -> onFailure(value)
}

inline fun <S1, S2, F> ResultOf<S1, F>.mapSuccess(
    transform: (S1) -> S2,
): ResultOf<S2, F> = when (this) {
    is ResultOf.Success -> ResultOf.Success(transform(value))
    is ResultOf.Failure -> this
}

inline fun <S, F1, F2> ResultOf<S, F1>.mapFailure(
    transform: (F1) -> F2,
): ResultOf<S, F2> = when (this) {
    is ResultOf.Success -> this
    is ResultOf.Failure -> ResultOf.Failure(transform(value))
}

inline fun <S, F> ResultOf<S, F>.onSuccess(
    action: (S) -> Unit,
): ResultOf<S, F> = apply {
    when (this) {
        is ResultOf.Success -> action(value)
        is ResultOf.Failure -> Unit
    }
}

inline fun <S, F> ResultOf<S, F>.onFailure(
    action: (F) -> Unit,
): ResultOf<S, F> = apply {
    when (this) {
        is ResultOf.Success -> Unit
        is ResultOf.Failure -> action(value)
    }
}

inline fun <S, reified F : Throwable> ResultOf<S, F>.throwIf(
    predicate: (F) -> Boolean,
): ResultOf<S, F> = onFailure {
    if (predicate(it)) throw it
}