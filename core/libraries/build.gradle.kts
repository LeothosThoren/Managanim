plugins {
    alias(libs.plugins.manganimu.library)
    alias(libs.plugins.manganimu.compose)
}

android {
    namespace = "com.thoren.manganimu.core.librairies"
}

dependencies {
    implementation(projects.core.ui)

    implementation(libs.androidx.media3.exoplayer)
    implementation(libs.androidx.media3.ui)
    implementation(libs.hilt.android)
    implementation(libs.hilt.core)

}