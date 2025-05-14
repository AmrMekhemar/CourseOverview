package com.tahhan.course.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple = Color(0xFF6B74F8)
val PurplePillBackground = Color(0xFFEFEFFC)
val GreenPill = Color(0xFF03A564)
val GreenPillBackground = Color(0xFFE5FBF2)
val TealPill = Color(0xFF07A8A2)
val TealPillBackground = Color(0xFFEFFCFB)
val PinkPillText = Color(0xFFDC3C9A)
val PinkPillBackground = Color(0xFFFDE5F3)
val PrimaryText = Color(0xFF13182C)
val SecondaryText = Color(0xFF4C4F59)
val Stroke = Color(0xFFE5E5E9)
val CardBackground = Color(0xFFF5F5F8)
val TeacherPillBackground = Color(0x4DF9E2F3)
val ColorScheme.TeacherAvatarStroke: Brush
    get() = Brush.verticalGradient(
        listOf(
            Color(0xFF6B74F8),
            Color(0xFFFDE5F3),
        )
    )
