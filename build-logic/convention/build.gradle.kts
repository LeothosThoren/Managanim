import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.thoren.manganimu.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_21
    }
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.compose.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.ksp.gradle.plugin)
    compileOnly(libs.room.gradle.plugin)
}

gradlePlugin {
    /**
     * Register convention plugins so they are available in the build scripts of the application
     */
    plugins {
        register("manganimuApplication") {
            id = "manganimu.application"
            implementationClass = "ApplicationConventionPlugin"
        }
        register("manganimuCompose") {
            id = "manganimu.compose"
            implementationClass = "ComposeConventionPlugin"
        }
        register("manganimuHilt") {
            id = "manganimu.hilt"
            implementationClass = "HiltConventionPlugin"
        }
        register("manganimuLibrary") {
            id = "manganimu.library"
            implementationClass = "LibraryConventionPlugin"
        }
        register("manganimuFeature") {
            id = "manganimu.feature"
            implementationClass = "FeatureConventionPlugin"
        }
        register("manganimuTest") {
            id = "manganimu.test"
            implementationClass = "TestConventionPlugin"
        }
    }
}