plugins {
    alias(libs.plugins.manganimu.library)
    alias(libs.plugins.manganimu.hilt)
}

android {
    namespace = "com.thoren.manganimu.core.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)

    testImplementation(libs.kotlinx.coroutines.test)
}