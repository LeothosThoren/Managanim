plugins {
    alias(libs.plugins.manganimu.library)
}

android {
    namespace = "com.thoren.manganimu.network"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
    implementation(platform(libs.squareup.okhttp3.bom))
    implementation(libs.squareup.okhttp3)
    implementation(libs.squareup.logging.interceptor)
    implementation(libs.squareup.converter.kotlinx.serialization)
    implementation(libs.squareup.retrofit2)

    testImplementation(libs.kotlinx.coroutines.test)
}