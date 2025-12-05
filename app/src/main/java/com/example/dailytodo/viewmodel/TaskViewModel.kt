package com.example.dailytodo.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.dailytodo.model.Task
import java.time.LocalDate

class TaskViewModel : ViewModel() {

    private val _tasks = mutableStateListOf<Task>()
    val tasks: List<Task> get() = _tasks

    // 오늘 날짜 기본 추가
    fun addTask(text: String, date: LocalDate = LocalDate.now()) {
        _tasks.add(Task(text = text, date = date))
    }

    fun toggleTask(task: Task, completed: Boolean) {
        val index = _tasks.indexOf(task)
        if (index != -1) {
            _tasks[index] = _tasks[index].copy(completed = completed)
        }
    }

    fun deleteTask(task: Task) {
        _tasks.remove(task)
    }

    val completedTasks: List<Task>
        get() = _tasks.filter { it.completed }

    fun getTasksByDate(date: LocalDate): List<Task> {
        return _tasks.filter { it.date == date }
    }
}
