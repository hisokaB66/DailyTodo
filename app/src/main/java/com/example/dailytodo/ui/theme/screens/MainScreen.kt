package com.example.dailytodo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dailytodo.ui.components.TodoList
import com.example.dailytodo.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: TaskViewModel = viewModel(),
    onCompletedClick: () -> Unit,
    onCalendarClick: () -> Unit
) {
    val incompleteTasks = viewModel.tasks.value.filter { !it.isDone }
    val completedTasks = viewModel.tasks.value.filter { it.isDone }

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text("DailyTodo") }
            )
        },
        bottomBar = {
            BottomNavigationBar(
                onCompletedClick = onCompletedClick,
                onCalendarClick = onCalendarClick
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {

            Text("할 일", style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(8.dp))
            TodoList(
                todos = incompleteTasks,
                onToggleTodo = { viewModel.toggleTask(it.id) }
            )

            Spacer(Modifier.height(20.dp))

            Text("완료", style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(8.dp))
            TodoList(
                todos = completedTasks,
                onToggleTodo = { viewModel.toggleTask(it.id) }
            )
        }
    }
}

@Composable
fun BottomNavigationBar(
    onCompletedClick: () -> Unit,
    onCalendarClick: () -> Unit
) {
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = { /* 현재 화면 */ },
            label = { Text("Todo") },
            icon = { Icon(Icons.Default.List, contentDescription = "Todo") }
        )
        NavigationBarItem(
            selected = false,
            onClick = onCompletedClick,
            label = { Text("완료") },
            icon = { Icon(Icons.Default.Done, contentDescription = "완료") }
        )
        NavigationBarItem(
            selected = false,
            onClick = onCalendarClick,
            label = { Text("캘린더") },
            icon = { Icon(Icons.Default.CalendarMonth, contentDescription = "캘린더") }
        )
    }
}
