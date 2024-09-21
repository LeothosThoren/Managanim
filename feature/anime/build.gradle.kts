plugins {
    alias(libs.plugins.manganimu.feature)
    alias(libs.plugins.manganimu.compose)
}

android {
    namespace = "com.thoren.manganimu.feature.anime"
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}