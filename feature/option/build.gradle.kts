plugins {
    alias(libs.plugins.manganimu.feature)
    alias(libs.plugins.manganimu.compose)
}

android {
    namespace = "com.thoren.manganimu.feature.option"
}

dependencies {
    // Todo replace it with project test module dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}