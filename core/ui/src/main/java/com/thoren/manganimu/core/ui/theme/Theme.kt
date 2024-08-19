import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.thoren.manganimu.core.ui.theme.backgroundDark
import com.thoren.manganimu.core.ui.theme.backgroundDarkHighContrast
import com.thoren.manganimu.core.ui.theme.backgroundDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.backgroundLight
import com.thoren.manganimu.core.ui.theme.backgroundLightHighContrast
import com.thoren.manganimu.core.ui.theme.backgroundLightMediumContrast
import com.thoren.manganimu.core.ui.theme.errorContainerDark
import com.thoren.manganimu.core.ui.theme.errorContainerDarkHighContrast
import com.thoren.manganimu.core.ui.theme.errorContainerDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.errorContainerLight
import com.thoren.manganimu.core.ui.theme.errorContainerLightHighContrast
import com.thoren.manganimu.core.ui.theme.errorContainerLightMediumContrast
import com.thoren.manganimu.core.ui.theme.errorDark
import com.thoren.manganimu.core.ui.theme.errorDarkHighContrast
import com.thoren.manganimu.core.ui.theme.errorDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.errorLight
import com.thoren.manganimu.core.ui.theme.errorLightHighContrast
import com.thoren.manganimu.core.ui.theme.errorLightMediumContrast
import com.thoren.manganimu.core.ui.theme.inverseOnSurfaceDark
import com.thoren.manganimu.core.ui.theme.inverseOnSurfaceDarkHighContrast
import com.thoren.manganimu.core.ui.theme.inverseOnSurfaceDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.inverseOnSurfaceLight
import com.thoren.manganimu.core.ui.theme.inverseOnSurfaceLightHighContrast
import com.thoren.manganimu.core.ui.theme.inverseOnSurfaceLightMediumContrast
import com.thoren.manganimu.core.ui.theme.inversePrimaryDark
import com.thoren.manganimu.core.ui.theme.inversePrimaryDarkHighContrast
import com.thoren.manganimu.core.ui.theme.inversePrimaryDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.inversePrimaryLight
import com.thoren.manganimu.core.ui.theme.inversePrimaryLightHighContrast
import com.thoren.manganimu.core.ui.theme.inversePrimaryLightMediumContrast
import com.thoren.manganimu.core.ui.theme.inverseSurfaceDark
import com.thoren.manganimu.core.ui.theme.inverseSurfaceDarkHighContrast
import com.thoren.manganimu.core.ui.theme.inverseSurfaceDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.inverseSurfaceLight
import com.thoren.manganimu.core.ui.theme.inverseSurfaceLightHighContrast
import com.thoren.manganimu.core.ui.theme.inverseSurfaceLightMediumContrast
import com.thoren.manganimu.core.ui.theme.onBackgroundDark
import com.thoren.manganimu.core.ui.theme.onBackgroundDarkHighContrast
import com.thoren.manganimu.core.ui.theme.onBackgroundDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.onBackgroundLight
import com.thoren.manganimu.core.ui.theme.onBackgroundLightHighContrast
import com.thoren.manganimu.core.ui.theme.onBackgroundLightMediumContrast
import com.thoren.manganimu.core.ui.theme.onErrorContainerDark
import com.thoren.manganimu.core.ui.theme.onErrorContainerDarkHighContrast
import com.thoren.manganimu.core.ui.theme.onErrorContainerDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.onErrorContainerLight
import com.thoren.manganimu.core.ui.theme.onErrorContainerLightHighContrast
import com.thoren.manganimu.core.ui.theme.onErrorContainerLightMediumContrast
import com.thoren.manganimu.core.ui.theme.onErrorDark
import com.thoren.manganimu.core.ui.theme.onErrorDarkHighContrast
import com.thoren.manganimu.core.ui.theme.onErrorDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.onErrorLight
import com.thoren.manganimu.core.ui.theme.onErrorLightHighContrast
import com.thoren.manganimu.core.ui.theme.onErrorLightMediumContrast
import com.thoren.manganimu.core.ui.theme.onPrimaryContainerDark
import com.thoren.manganimu.core.ui.theme.onPrimaryContainerDarkHighContrast
import com.thoren.manganimu.core.ui.theme.onPrimaryContainerDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.onPrimaryContainerLight
import com.thoren.manganimu.core.ui.theme.onPrimaryContainerLightHighContrast
import com.thoren.manganimu.core.ui.theme.onPrimaryContainerLightMediumContrast
import com.thoren.manganimu.core.ui.theme.onPrimaryDark
import com.thoren.manganimu.core.ui.theme.onPrimaryDarkHighContrast
import com.thoren.manganimu.core.ui.theme.onPrimaryDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.onPrimaryLight
import com.thoren.manganimu.core.ui.theme.onPrimaryLightHighContrast
import com.thoren.manganimu.core.ui.theme.onPrimaryLightMediumContrast
import com.thoren.manganimu.core.ui.theme.onSecondaryContainerDark
import com.thoren.manganimu.core.ui.theme.onSecondaryContainerDarkHighContrast
import com.thoren.manganimu.core.ui.theme.onSecondaryContainerDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.onSecondaryContainerLight
import com.thoren.manganimu.core.ui.theme.onSecondaryContainerLightHighContrast
import com.thoren.manganimu.core.ui.theme.onSecondaryContainerLightMediumContrast
import com.thoren.manganimu.core.ui.theme.onSecondaryDark
import com.thoren.manganimu.core.ui.theme.onSecondaryDarkHighContrast
import com.thoren.manganimu.core.ui.theme.onSecondaryDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.onSecondaryLight
import com.thoren.manganimu.core.ui.theme.onSecondaryLightHighContrast
import com.thoren.manganimu.core.ui.theme.onSecondaryLightMediumContrast
import com.thoren.manganimu.core.ui.theme.onSurfaceDark
import com.thoren.manganimu.core.ui.theme.onSurfaceDarkHighContrast
import com.thoren.manganimu.core.ui.theme.onSurfaceDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.onSurfaceLight
import com.thoren.manganimu.core.ui.theme.onSurfaceLightHighContrast
import com.thoren.manganimu.core.ui.theme.onSurfaceLightMediumContrast
import com.thoren.manganimu.core.ui.theme.onSurfaceVariantDark
import com.thoren.manganimu.core.ui.theme.onSurfaceVariantDarkHighContrast
import com.thoren.manganimu.core.ui.theme.onSurfaceVariantDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.onSurfaceVariantLight
import com.thoren.manganimu.core.ui.theme.onSurfaceVariantLightHighContrast
import com.thoren.manganimu.core.ui.theme.onSurfaceVariantLightMediumContrast
import com.thoren.manganimu.core.ui.theme.onTertiaryContainerDark
import com.thoren.manganimu.core.ui.theme.onTertiaryContainerDarkHighContrast
import com.thoren.manganimu.core.ui.theme.onTertiaryContainerDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.onTertiaryContainerLight
import com.thoren.manganimu.core.ui.theme.onTertiaryContainerLightHighContrast
import com.thoren.manganimu.core.ui.theme.onTertiaryContainerLightMediumContrast
import com.thoren.manganimu.core.ui.theme.onTertiaryDark
import com.thoren.manganimu.core.ui.theme.onTertiaryDarkHighContrast
import com.thoren.manganimu.core.ui.theme.onTertiaryDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.onTertiaryLight
import com.thoren.manganimu.core.ui.theme.onTertiaryLightHighContrast
import com.thoren.manganimu.core.ui.theme.onTertiaryLightMediumContrast
import com.thoren.manganimu.core.ui.theme.outlineDark
import com.thoren.manganimu.core.ui.theme.outlineDarkHighContrast
import com.thoren.manganimu.core.ui.theme.outlineDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.outlineLight
import com.thoren.manganimu.core.ui.theme.outlineLightHighContrast
import com.thoren.manganimu.core.ui.theme.outlineLightMediumContrast
import com.thoren.manganimu.core.ui.theme.outlineVariantDark
import com.thoren.manganimu.core.ui.theme.outlineVariantDarkHighContrast
import com.thoren.manganimu.core.ui.theme.outlineVariantDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.outlineVariantLight
import com.thoren.manganimu.core.ui.theme.outlineVariantLightHighContrast
import com.thoren.manganimu.core.ui.theme.outlineVariantLightMediumContrast
import com.thoren.manganimu.core.ui.theme.primaryContainerDark
import com.thoren.manganimu.core.ui.theme.primaryContainerDarkHighContrast
import com.thoren.manganimu.core.ui.theme.primaryContainerDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.primaryContainerLight
import com.thoren.manganimu.core.ui.theme.primaryContainerLightHighContrast
import com.thoren.manganimu.core.ui.theme.primaryContainerLightMediumContrast
import com.thoren.manganimu.core.ui.theme.primaryDark
import com.thoren.manganimu.core.ui.theme.primaryDarkHighContrast
import com.thoren.manganimu.core.ui.theme.primaryDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.primaryLight
import com.thoren.manganimu.core.ui.theme.primaryLightHighContrast
import com.thoren.manganimu.core.ui.theme.primaryLightMediumContrast
import com.thoren.manganimu.core.ui.theme.scrimDark
import com.thoren.manganimu.core.ui.theme.scrimDarkHighContrast
import com.thoren.manganimu.core.ui.theme.scrimDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.scrimLight
import com.thoren.manganimu.core.ui.theme.scrimLightHighContrast
import com.thoren.manganimu.core.ui.theme.scrimLightMediumContrast
import com.thoren.manganimu.core.ui.theme.secondaryContainerDark
import com.thoren.manganimu.core.ui.theme.secondaryContainerDarkHighContrast
import com.thoren.manganimu.core.ui.theme.secondaryContainerDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.secondaryContainerLight
import com.thoren.manganimu.core.ui.theme.secondaryContainerLightHighContrast
import com.thoren.manganimu.core.ui.theme.secondaryContainerLightMediumContrast
import com.thoren.manganimu.core.ui.theme.secondaryDark
import com.thoren.manganimu.core.ui.theme.secondaryDarkHighContrast
import com.thoren.manganimu.core.ui.theme.secondaryDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.secondaryLight
import com.thoren.manganimu.core.ui.theme.secondaryLightHighContrast
import com.thoren.manganimu.core.ui.theme.secondaryLightMediumContrast
import com.thoren.manganimu.core.ui.theme.shapes
import com.thoren.manganimu.core.ui.theme.surfaceBrightDark
import com.thoren.manganimu.core.ui.theme.surfaceBrightDarkHighContrast
import com.thoren.manganimu.core.ui.theme.surfaceBrightDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.surfaceBrightLight
import com.thoren.manganimu.core.ui.theme.surfaceBrightLightHighContrast
import com.thoren.manganimu.core.ui.theme.surfaceBrightLightMediumContrast
import com.thoren.manganimu.core.ui.theme.surfaceContainerDark
import com.thoren.manganimu.core.ui.theme.surfaceContainerDarkHighContrast
import com.thoren.manganimu.core.ui.theme.surfaceContainerDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.surfaceContainerHighDark
import com.thoren.manganimu.core.ui.theme.surfaceContainerHighDarkHighContrast
import com.thoren.manganimu.core.ui.theme.surfaceContainerHighDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.surfaceContainerHighLight
import com.thoren.manganimu.core.ui.theme.surfaceContainerHighLightHighContrast
import com.thoren.manganimu.core.ui.theme.surfaceContainerHighLightMediumContrast
import com.thoren.manganimu.core.ui.theme.surfaceContainerHighestDark
import com.thoren.manganimu.core.ui.theme.surfaceContainerHighestDarkHighContrast
import com.thoren.manganimu.core.ui.theme.surfaceContainerHighestDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.surfaceContainerHighestLight
import com.thoren.manganimu.core.ui.theme.surfaceContainerHighestLightHighContrast
import com.thoren.manganimu.core.ui.theme.surfaceContainerHighestLightMediumContrast
import com.thoren.manganimu.core.ui.theme.surfaceContainerLight
import com.thoren.manganimu.core.ui.theme.surfaceContainerLightHighContrast
import com.thoren.manganimu.core.ui.theme.surfaceContainerLightMediumContrast
import com.thoren.manganimu.core.ui.theme.surfaceContainerLowDark
import com.thoren.manganimu.core.ui.theme.surfaceContainerLowDarkHighContrast
import com.thoren.manganimu.core.ui.theme.surfaceContainerLowDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.surfaceContainerLowLight
import com.thoren.manganimu.core.ui.theme.surfaceContainerLowLightHighContrast
import com.thoren.manganimu.core.ui.theme.surfaceContainerLowLightMediumContrast
import com.thoren.manganimu.core.ui.theme.surfaceContainerLowestDark
import com.thoren.manganimu.core.ui.theme.surfaceContainerLowestDarkHighContrast
import com.thoren.manganimu.core.ui.theme.surfaceContainerLowestDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.surfaceContainerLowestLight
import com.thoren.manganimu.core.ui.theme.surfaceContainerLowestLightHighContrast
import com.thoren.manganimu.core.ui.theme.surfaceContainerLowestLightMediumContrast
import com.thoren.manganimu.core.ui.theme.surfaceDark
import com.thoren.manganimu.core.ui.theme.surfaceDarkHighContrast
import com.thoren.manganimu.core.ui.theme.surfaceDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.surfaceDimDark
import com.thoren.manganimu.core.ui.theme.surfaceDimDarkHighContrast
import com.thoren.manganimu.core.ui.theme.surfaceDimDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.surfaceDimLight
import com.thoren.manganimu.core.ui.theme.surfaceDimLightHighContrast
import com.thoren.manganimu.core.ui.theme.surfaceDimLightMediumContrast
import com.thoren.manganimu.core.ui.theme.surfaceLight
import com.thoren.manganimu.core.ui.theme.surfaceLightHighContrast
import com.thoren.manganimu.core.ui.theme.surfaceLightMediumContrast
import com.thoren.manganimu.core.ui.theme.surfaceVariantDark
import com.thoren.manganimu.core.ui.theme.surfaceVariantDarkHighContrast
import com.thoren.manganimu.core.ui.theme.surfaceVariantDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.surfaceVariantLight
import com.thoren.manganimu.core.ui.theme.surfaceVariantLightHighContrast
import com.thoren.manganimu.core.ui.theme.surfaceVariantLightMediumContrast
import com.thoren.manganimu.core.ui.theme.tertiaryContainerDark
import com.thoren.manganimu.core.ui.theme.tertiaryContainerDarkHighContrast
import com.thoren.manganimu.core.ui.theme.tertiaryContainerDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.tertiaryContainerLight
import com.thoren.manganimu.core.ui.theme.tertiaryContainerLightHighContrast
import com.thoren.manganimu.core.ui.theme.tertiaryContainerLightMediumContrast
import com.thoren.manganimu.core.ui.theme.tertiaryDark
import com.thoren.manganimu.core.ui.theme.tertiaryDarkHighContrast
import com.thoren.manganimu.core.ui.theme.tertiaryDarkMediumContrast
import com.thoren.manganimu.core.ui.theme.tertiaryLight
import com.thoren.manganimu.core.ui.theme.tertiaryLightHighContrast
import com.thoren.manganimu.core.ui.theme.tertiaryLightMediumContrast
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

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
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
            window.statusBarColor = colors.primary.toArgb()
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