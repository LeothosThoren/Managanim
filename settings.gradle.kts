import java.nio.file.FileVisitResult
import java.nio.file.FileVisitResult.CONTINUE
import java.nio.file.FileVisitResult.SKIP_SUBTREE
import java.nio.file.FileVisitor
import java.nio.file.Files.walkFileTree
import java.nio.file.Path
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes
import kotlin.io.path.relativeTo

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

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")

listOf(
    "core",
    "data",
    "domain",
    "feature",
).forEach { includeRecursively(root = layout.settingsDirectory, path = it) }

fun Settings.includeRecursively(root: Directory, path: String): Path = walkFileTree(
    /* start = */
    root.dir(path).asFile.toPath(),
    /* visitor = */
    GradleBuildFileVisitor {
        include(
            it.parent.relativeTo(root.asFile.toPath()).joinToString(":")
        )
    },
)

/**
 * This [FileVisitor] looks for gradle build files named `build.gradle.kts` and skip uninteresting directories.
 */
internal class GradleBuildFileVisitor(
    private val action: (Path) -> Unit,
) : SimpleFileVisitor<Path>() {
    override fun preVisitDirectory(dir: Path, attrs: BasicFileAttributes) =
        when (dir.fileName.toString()) {
            "build", "build-cache", "src", ".git", ".gradle" -> SKIP_SUBTREE
            else -> CONTINUE
        }

    override fun visitFile(path: Path, attrs: BasicFileAttributes): FileVisitResult {
        if (path.endsWith("build.gradle.kts")) action(path)
        return CONTINUE
    }
}