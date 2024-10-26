plugins {
    alias(libs.plugins.manganimu.feature)
    alias(libs.plugins.manganimu.compose)
}

android {
    namespace = "com.thoren.manganimu.feature.anime"
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.models)
    implementation(projects.domain.anime)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}