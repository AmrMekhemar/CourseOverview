package com.tahhan.course.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = PurplePillBackground,
    onPrimary = Purple,
    secondary = GreenPillBackground,
    onSecondary = GreenPill,
    tertiary = TealPillBackground,
    background = CardBackground,
    onBackground = PrimaryText,
    onSurface = SecondaryText,
)

@Composable
fun CourseTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}