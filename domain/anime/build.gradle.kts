plugins {
    alias(libs.plugins.manganimu.library)
    alias(libs.plugins.manganimu.hilt)
}

android {
    namespace = "com.thoren.manganimu.domain.anime"
}

dependencies {
    api(project(":data:anime"))

    implementation(project(":core:common"))
    implementation(project(":core:models"))
}

