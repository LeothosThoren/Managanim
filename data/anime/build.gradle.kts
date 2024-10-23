plugins {
    alias(libs.plugins.manganimu.library)
    alias(libs.plugins.manganimu.hilt)
}

android {
    namespace = "com.thoren.manganimu.data.anime"
}

dependencies {
    api(project(":core:models"))

    implementation(project(":core:common"))
    implementation(project(":core:network"))
    implementation(project(":domain:anime"))
}