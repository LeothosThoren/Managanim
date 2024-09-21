plugins {
    alias(libs.plugins.manganimu.library)
}

android {
    namespace = "com.thoren.manganimu.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)

    testImplementation(libs.kotlinx.coroutines.test)
}