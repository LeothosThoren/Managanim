package com.thoren.manganimu

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import javax.inject.Provider

@HiltAndroidApp
class ManaganimuApplication : Application(), ImageLoaderFactory {

    @Inject
    lateinit var imageLoader: Provider<ImageLoader>

    override fun newImageLoader(): ImageLoader = imageLoader.get()
}