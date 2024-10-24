plugins {
    alias(libs.plugins.manganimu.library)
    alias(libs.plugins.manganimu.hilt)
}

android {
    namespace = "com.thoren.manganimu.domain.anime"
}

dependencies {
    api(projects.data.anime)

    implementation(projects.core.common)
    implementation(projects.core.models)
}

