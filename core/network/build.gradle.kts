plugins {
    alias(libs.plugins.manganimu.library)
    alias(libs.plugins.manganimu.hilt)
}

android {
    namespace = "com.thoren.manganimu.core.network"
    kotlinOptions {
        freeCompilerArgs += listOf("-Xopt-in=kotlinx.serialization.InternalSerializationApi")
    }
}

dependencies {
    implementation(projects.core.common)

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(platform(libs.squareup.okhttp3.bom))
    implementation(libs.squareup.okhttp3)
    implementation(libs.squareup.logging.interceptor)
    implementation(libs.squareup.converter.kotlinx.serialization)
    implementation(libs.squareup.retrofit2)

    testImplementation(libs.kotlinx.coroutines.test)
}