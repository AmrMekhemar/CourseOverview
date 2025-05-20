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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
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
import com.tahhan.course.ui.Course
import com.tahhan.course.ui.course
import com.tahhan.course.ui.theme.CourseTheme
import com.tahhan.course.ui.theme.PrimaryText
import com.tahhan.course.ui.theme.TeacherPillBackground

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CourseOverviewScreen(
    course: Course,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier.padding(start = 20.dp, top = 28.dp, 8.dp, bottom = 72.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = course.name,
                style = MaterialTheme.typography.headlineLarge,
                color = PrimaryText
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = course.description,
                style = MaterialTheme.typography.labelSmall
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
            Text(
                text = "What you'll learn",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(Modifier.height(8.dp))
            LazyColumn {
                items(course.whatToLearn) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.arrow),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                        Text(
                            text = it,
                            style = MaterialTheme.typography.labelLarge
                        )

                    }
                }
            }
            Spacer(Modifier.height(24.dp))
        }
        DrCard(
            course.teacher,
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun CourseOverviewScreenPreview() {
    CourseTheme {
        CourseOverviewScreen(course = course)
    }
}


