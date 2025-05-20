package com.tahhan.course.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tahhan.course.R
import com.tahhan.course.ui.Difficulty
import com.tahhan.course.ui.theme.CourseTheme
import com.tahhan.course.ui.theme.PinkPillBackground
import com.tahhan.course.ui.theme.PinkPillText
import com.tahhan.course.ui.theme.SecondaryText
import com.tahhan.course.ui.theme.Stroke

@Composable
fun DifficultyCard(
    difficulty: Difficulty,
    modifier: Modifier = Modifier
) {
    val backgroundTint = when (difficulty) {
        Difficulty.EASY -> MaterialTheme.colorScheme.secondary
        Difficulty.INTERMEDIATE -> MaterialTheme.colorScheme.primary
        Difficulty.HARD -> PinkPillBackground
    }
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(25.dp))
            .background(backgroundTint)
    ) {
        val icon = when (difficulty) {
            Difficulty.EASY -> painterResource(R.drawable.easy_icon)
            Difficulty.INTERMEDIATE -> painterResource(R.drawable.medium_icon)
            Difficulty.HARD -> painterResource(R.drawable.hard_icon)
        }

        val difficultyLevel = when (difficulty) {
            Difficulty.EASY -> "Easy"
            Difficulty.INTERMEDIATE -> "Intermediate"
            Difficulty.HARD -> "Hard"
        }

        val onBackgroundTint = when (difficulty) {
            Difficulty.EASY -> MaterialTheme.colorScheme.onSecondary
            Difficulty.INTERMEDIATE -> MaterialTheme.colorScheme.onPrimary
            Difficulty.HARD -> PinkPillText
        }

        Row(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                painter = icon,
                tint = onBackgroundTint,
                contentDescription = null
            )
            Text(
                text = difficultyLevel,
                color = onBackgroundTint,
                style = MaterialTheme.typography.labelMedium,
            )
        }
    }
}

@Composable
fun SubjectCard(
    subject: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(25.dp))
            .background(MaterialTheme.colorScheme.secondary)
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(
            text = subject,
            color = MaterialTheme.colorScheme.onSecondary,
            style = MaterialTheme.typography.labelMedium,
        )
    }
}

@Composable
fun DurationCard(
    duration: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .border(
                border = BorderStroke(width = 1.dp, color = Stroke),
                shape = RoundedCornerShape(25.dp)
            )
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.clock_icon),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = "$duration mins",
                color = SecondaryText,
                style = MaterialTheme.typography.labelMedium,
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DifficultyEasyCardPreview() {
    CourseTheme {
        DifficultyCard(Difficulty.EASY)
    }
}

@Composable
@Preview(showBackground = true)
fun DifficultyIntermediateCardPreview() {
    CourseTheme {
        DifficultyCard(Difficulty.INTERMEDIATE)
    }
}

@Composable
@Preview(showBackground = true)
fun DifficultyHardCardPreview() {
    CourseTheme {
        DifficultyCard(Difficulty.HARD)
    }
}

@Composable
@Preview(showBackground = true)
fun SubjectCardPreview() {
    CourseTheme {
        SubjectCard("Science")
    }
}

@Composable
@Preview(showBackground = true)
fun DurationCardPreview() {
    CourseTheme {
        DurationCard(15)
    }
}