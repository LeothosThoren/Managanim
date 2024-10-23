package com.thoren.manganimu.domain.anime.di

import com.thoren.manganimu.domain.anime.usecases.GetPopularAnimeUseCase
import com.thoren.manganimu.domain.anime.usecases.GetPopularAnimeUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DomainAnimeModule {

    @Binds
    fun bindGetPopularAnimeUseCase(
        impl: GetPopularAnimeUseCaseImpl,
    ): GetPopularAnimeUseCase
}