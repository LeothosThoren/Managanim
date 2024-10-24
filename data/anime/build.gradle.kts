plugins {
    alias(libs.plugins.manganimu.library)
    alias(libs.plugins.manganimu.hilt)
}

android {
    namespace = "com.thoren.manganimu.data.anime"
}

dependencies {
    api(projects.core.models)

    implementation(projects.core.common)
    implementation(projects.core.network)
    implementation(projects.domain.anime)
}