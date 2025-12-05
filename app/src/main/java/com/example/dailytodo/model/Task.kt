package com.example.dailytodo.model

import java.time.LocalDate

data class Task(
    val id: Long = System.currentTimeMillis(), // 고유 ID
    val text: String,
    val date: LocalDate = LocalDate.now(),     // 기본값: 오늘
    var completed: Boolean = false
)
