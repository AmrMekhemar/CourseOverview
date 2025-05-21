package com.tahhan.course.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.tahhan.course.ui.theme.CourseTheme
import com.tahhan.course.ui.theme.PrimaryText
import com.tahhan.course.ui.theme.TeacherAvatarStroke
import com.tahhan.course.ui.theme.TeacherPillBackground

@Composable
fun DrCard(
    name: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(TeacherPillBackground)
            .padding(8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(
                        brush = MaterialTheme.colorScheme.TeacherAvatarStroke
                    )
                    .padding(2.dp)
            ) {
                Image(
                    modifier = Modifier
                        .clip(CircleShape)
                        .align(Alignment.Center),
                    painter = painterResource(R.drawable.dr_image),
                    contentDescription = "Dr photo"
                )
            }
            Text(
                text = "Dr. $name",
                style = MaterialTheme.typography.headlineSmall,
                color = PrimaryText
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DrCardPreview(){
    CourseTheme {
        DrCard("Eleanor Maxwell")
    }
}