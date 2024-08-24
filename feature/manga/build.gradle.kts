plugins {
    alias(libs.plugins.manganimu.feature)
    alias(libs.plugins.manganimu.compose)
}

android {
    namespace = "com.thoren.manganimu.feature.manga"
}

dependencies {
    // Todo replace it with project test module dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}