package com.tahhan.course.ui

data class Course(
    val name: String,
    val description: String,
    val difficulty: Difficulty,
    val subjects: List<String>,
    val durationInMins: Int,
    val whatToLearn: List<String>
)

enum class Difficulty {
    EASY,
    INTERMEDIATE,
    HARD
}


