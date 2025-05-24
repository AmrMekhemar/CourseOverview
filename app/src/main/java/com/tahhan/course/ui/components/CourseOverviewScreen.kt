package com.tahhan.course.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.window.core.layout.WindowSizeClass
import com.tahhan.course.R
import com.tahhan.course.ui.Course
import com.tahhan.course.ui.course
import com.tahhan.course.ui.theme.CourseTheme
import com.tahhan.course.ui.theme.PrimaryText
import com.tahhan.course.ui.theme.SecondaryText

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CourseOverviewScreen(
    course: Course,
    modifier: Modifier = Modifier
) {
    val isNotCompact = currentWindowAdaptiveInfo().windowSizeClass
        .isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND)

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier.padding(start = 20.dp, top = 28.dp, 8.dp, bottom = 88.dp),
            horizontalAlignment = if (isNotCompact) Alignment.CenterHorizontally else Alignment.Start
        ) {
            Text(
                text = course.name,
                style = MaterialTheme.typography.headlineLarge,
                color = PrimaryText
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = course.description,
                style = MaterialTheme.typography.labelSmall,
                color = SecondaryText,
                textAlign = if (isNotCompact) TextAlign.Center else TextAlign.Start
            )
            Spacer(Modifier.height(16.dp))
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                DifficultyCard(course.difficulty)
                course.subjects.forEach {
                    SubjectCard(it)
                }
                DurationCard(course.durationInMins)
            }
            Spacer(Modifier.height(24.dp))
            HorizontalDivider()
            Spacer(Modifier.height(24.dp))
            LazyColumn(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                stickyHeader {
                    Text(
                        text = "What you'll learn",
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.align(Alignment.Start)
                    )
                    Spacer(Modifier.height(2.dp))
                }
                items(course.whatToLearn) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.arrow),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.alignBy { it.measuredHeight  })
                        Text(
                            text = it,
                            style = MaterialTheme.typography.labelLarge,
                            modifier = Modifier.alignBy(FirstBaseline)
                        )
                    }
                }
            }
        }
        DrCard(
            course.teacher,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 20.dp, vertical = 16.dp)
        )
    }
}


@PreviewScreenSizes
@Composable
fun CourseOverviewScreenPreview() {
    CourseTheme {
        CourseOverviewScreen(course = course)
    }
}


