package com.thoren.manganimu.data.anime.di

import com.thoren.manganimu.data.anime.AnimeRepositoryImpl
import com.thoren.manganimu.domain.anime.repositories.AnimeDetailsRepository
import com.thoren.manganimu.domain.anime.repositories.EpisodeRepository
import com.thoren.manganimu.domain.anime.repositories.PopularAnimeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {

    @Binds
    fun bindAnimeRepository(
        impl: AnimeRepositoryImpl,
    ): PopularAnimeRepository

    @Binds
    fun bindEpisodeRepository(
        impl: AnimeRepositoryImpl,
    ): EpisodeRepository

    @Binds
    fun bindAnimeDetailsRepository(
        impl: AnimeRepositoryImpl,
    ): AnimeDetailsRepository
}