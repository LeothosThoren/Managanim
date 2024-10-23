package com.thoren.manganimu.network.injection.di

import com.thoren.manganimu.network.injection.RetrofitAnimeNetworkImpl
import com.thoren.manganimu.network.injection.networkdatasources.AnimeNetworkDataSource
import com.thoren.manganimu.network.injection.services.AnimeApiService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal interface AnimeNetworkModule {

    @Binds
    fun bindAnimeNetworkDataSource(
        retrofitAnimeNetwork: RetrofitAnimeNetworkImpl
    ): AnimeNetworkDataSource

    companion object {
        @Provides
        @BaseUrl
        fun baseUrl(): String = "https://api.amvstr.me/"

        @Provides
        fun animeApiService(retrofit: Retrofit): AnimeApiService {
            return retrofit.create(AnimeApiService::class.java)
        }
    }
}
