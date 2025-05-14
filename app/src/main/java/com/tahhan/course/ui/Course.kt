package com.tahhan.course.ui

data class Course(
    val name: String,
    val description: String,
    val difficulty: Difficulty,
    val subjects: List<String>,
    val durationInMins: Int,
    val whatToLearn: List<String>,
    val teacher: String
)

enum class Difficulty {
    EASY,
    INTERMEDIATE,
    HARD
}


val course = Course(
    name = "Physics Crash Course",
    description = "The Physics Crash Course offers a foundational overview of essential concepts, teaching learners to understand Newton’s three laws of motion, explain the principle of energy conservation, distinguish between kinetic and potential energy with real-world examples, solve basic problems involving force and mass, and apply the concept of momentum in everyday situations.",
    difficulty = Difficulty.INTERMEDIATE,
    subjects = listOf("Science", "Physics"),
    durationInMins = 15,
    whatToLearn = listOf(
        "Understand Newton's three laws of motion",
        "Explain the principle of energy conservation",
        "Identify real-world examples of kinetic and potential energy",
        "Solve simple physics problems involving force and mass",
        "Apply concepts of momentum in everyday scenarios",
    ),
    teacher = "Dr. Eleanor Maxwell"
)


