plugins {
    alias(libs.plugins.manganimu.library)
    alias(libs.plugins.manganimu.compose)
}

android {
    namespace = "com.thoren.manganimu.core.ui"
}

dependencies {
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.material3.adaptive)
    api(libs.androidx.compose.material3.adaptive.layout)
    api(libs.androidx.compose.material3.adaptive.navigation)
    api(libs.androidx.compose.material3.navigationSuite)
    api(libs.androidx.compose.material3.window.sizeClass)
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.ui.graphics)
    api(libs.androidx.compose.ui.tooling)
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.coil.compose)

    implementation(libs.androidx.core)
    implementation(libs.androidx.ui.text.google.fonts)
}