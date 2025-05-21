package com.tahhan.course

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.tahhan.course.ui.components.CourseOverviewScreen
import com.tahhan.course.ui.course
import com.tahhan.course.ui.theme.CourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainActivityUI()
        }
    }


}

@Composable
private fun MainActivityUI() {
    CourseTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = MaterialTheme.colorScheme.onPrimary,
            contentWindowInsets = WindowInsets.statusBars,
        ) { innerPadding ->
            CourseOverviewScreen(
                course = course,
                Modifier.padding(innerPadding)
            )
        }
    }
}

@PreviewScreenSizes
@Composable
fun MainActivityUIPreview() {
    MainActivityUI()
}