pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Manganimu"

include(":app")
include(":core:ui")
include(":feature:anime")
include(":feature:manga")
include(":feature:music")
include(":feature:option")
