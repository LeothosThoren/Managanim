plugins {
    alias(libs.plugins.manganimu.feature)
    alias(libs.plugins.manganimu.compose)
}

android {
    namespace = "com.thoren.manganimu.feature.music"
}

dependencies {
    implementation(projects.core.navigation)
    implementation(libs.androidx.navigation.compose)

    // Todo replace it with project test module dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}