import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.thoren.manganimu.core.ui.theme.backgroundDark
import com.thoren.manganimu.core.ui.theme.backgroundLight
import com.thoren.manganimu.core.ui.theme.errorContainerDark
import com.thoren.manganimu.core.ui.theme.errorContainerLight
import com.thoren.manganimu.core.ui.theme.errorDark
import com.thoren.manganimu.core.ui.theme.errorLight
import com.thoren.manganimu.core.ui.theme.inverseOnSurfaceDark
import com.thoren.manganimu.core.ui.theme.inverseOnSurfaceLight
import com.thoren.manganimu.core.ui.theme.inversePrimaryDark
import com.thoren.manganimu.core.ui.theme.inversePrimaryLight
import com.thoren.manganimu.core.ui.theme.inverseSurfaceDark
import com.thoren.manganimu.core.ui.theme.inverseSurfaceLight
import com.thoren.manganimu.core.ui.theme.onBackgroundDark
import com.thoren.manganimu.core.ui.theme.onBackgroundLight
import com.thoren.manganimu.core.ui.theme.onErrorContainerDark
import com.thoren.manganimu.core.ui.theme.onErrorContainerLight
import com.thoren.manganimu.core.ui.theme.onErrorDark
import com.thoren.manganimu.core.ui.theme.onErrorLight
import com.thoren.manganimu.core.ui.theme.onPrimaryContainerDark
import com.thoren.manganimu.core.ui.theme.onPrimaryContainerLight
import com.thoren.manganimu.core.ui.theme.onPrimaryDark
import com.thoren.manganimu.core.ui.theme.onPrimaryLight
import com.thoren.manganimu.core.ui.theme.onSecondaryContainerDark
import com.thoren.manganimu.core.ui.theme.onSecondaryContainerLight
import com.thoren.manganimu.core.ui.theme.onSecondaryDark
import com.thoren.manganimu.core.ui.theme.onSecondaryLight
import com.thoren.manganimu.core.ui.theme.onSurfaceDark
import com.thoren.manganimu.core.ui.theme.onSurfaceLight
import com.thoren.manganimu.core.ui.theme.onSurfaceVariantDark
import com.thoren.manganimu.core.ui.theme.onSurfaceVariantLight
import com.thoren.manganimu.core.ui.theme.onTertiaryContainerDark
import com.thoren.manganimu.core.ui.theme.onTertiaryContainerLight
import com.thoren.manganimu.core.ui.theme.onTertiaryDark
import com.thoren.manganimu.core.ui.theme.onTertiaryLight
import com.thoren.manganimu.core.ui.theme.outlineDark
import com.thoren.manganimu.core.ui.theme.outlineLight
import com.thoren.manganimu.core.ui.theme.outlineVariantDark
import com.thoren.manganimu.core.ui.theme.outlineVariantLight
import com.thoren.manganimu.core.ui.theme.primaryContainerDark
import com.thoren.manganimu.core.ui.theme.primaryContainerLight
import com.thoren.manganimu.core.ui.theme.primaryDark
import com.thoren.manganimu.core.ui.theme.primaryLight
import com.thoren.manganimu.core.ui.theme.scrimDark
import com.thoren.manganimu.core.ui.theme.scrimLight
import com.thoren.manganimu.core.ui.theme.secondaryContainerDark
import com.thoren.manganimu.core.ui.theme.secondaryContainerLight
import com.thoren.manganimu.core.ui.theme.secondaryDark
import com.thoren.manganimu.core.ui.theme.secondaryLight
import com.thoren.manganimu.core.ui.theme.shapes
import com.thoren.manganimu.core.ui.theme.surfaceBrightDark
import com.thoren.manganimu.core.ui.theme.surfaceBrightLight
import com.thoren.manganimu.core.ui.theme.surfaceContainerDark
import com.thoren.manganimu.core.ui.theme.surfaceContainerHighDark
import com.thoren.manganimu.core.ui.theme.surfaceContainerHighLight
import com.thoren.manganimu.core.ui.theme.surfaceContainerHighestDark
import com.thoren.manganimu.core.ui.theme.surfaceContainerHighestLight
import com.thoren.manganimu.core.ui.theme.surfaceContainerLight
import com.thoren.manganimu.core.ui.theme.surfaceContainerLowDark
import com.thoren.manganimu.core.ui.theme.surfaceContainerLowLight
import com.thoren.manganimu.core.ui.theme.surfaceContainerLowestDark
import com.thoren.manganimu.core.ui.theme.surfaceContainerLowestLight
import com.thoren.manganimu.core.ui.theme.surfaceDark
import com.thoren.manganimu.core.ui.theme.surfaceDimDark
import com.thoren.manganimu.core.ui.theme.surfaceDimLight
import com.thoren.manganimu.core.ui.theme.surfaceLight
import com.thoren.manganimu.core.ui.theme.surfaceVariantDark
import com.thoren.manganimu.core.ui.theme.surfaceVariantLight
import com.thoren.manganimu.core.ui.theme.tertiaryContainerDark
import com.thoren.manganimu.core.ui.theme.tertiaryContainerLight
import com.thoren.manganimu.core.ui.theme.tertiaryDark
import com.thoren.manganimu.core.ui.theme.tertiaryLight
import com.thoren.manganimu.core.ui.theme.typography


private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

@Composable
fun ManganimuTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val colors = when {
        (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) -> {
            if (useDarkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }

        useDarkTheme -> darkScheme
        else -> lightScheme
    }

    // Add primary status bar color from chosen color scheme.
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat
                .getInsetsController(window, view)
                .isAppearanceLightStatusBars = useDarkTheme
        }

        MaterialTheme(
            colorScheme = colors,
            typography = typography,
            shapes = shapes,
            content = content
        )
    }
}

@Composable
fun PreviewTheme(
    useDarkColors: Boolean = LocalInspectionMode.current && isSystemInDarkTheme(),
    padding: PaddingValues = PaddingValues(16.dp),
    contentPadding: Dp = 16.dp,
    content: @Composable (ColumnScope.() -> Unit),
) {

    val context = LocalContext.current
    val colors = when {
        (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) -> {
            if (useDarkColors) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }

        useDarkColors -> darkScheme
        else -> lightScheme
    }
    MaterialTheme(
        colorScheme = colors,
        typography = MaterialTheme.typography,
        shapes = shapes,
    ) {
        PreviewWrapper(
            padding = padding,
            contentPadding = contentPadding,
            content = content,
        )
    }
}

@Composable
private fun PreviewWrapper(
    padding: PaddingValues = PaddingValues(16.dp),
    contentPadding: Dp = 16.dp,
    color: @Composable () -> Color = { MaterialTheme.colorScheme.background },
    content: @Composable ColumnScope.() -> Unit,
) {
    Surface(
        color = color(),
    ) {
        Column(
            modifier = Modifier.padding(padding),
            verticalArrangement = Arrangement.spacedBy(contentPadding),
        ) {
            content()
        }
    }
}