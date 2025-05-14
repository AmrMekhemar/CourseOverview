package com.tahhan.course

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.tahhan.course.ui.components.CourseOverviewScreen
import com.tahhan.course.ui.course
import com.tahhan.course.ui.theme.CourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CourseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CourseOverviewScreen(
                        course = course,
                        Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}