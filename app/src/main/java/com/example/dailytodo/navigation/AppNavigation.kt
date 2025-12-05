package com.example.dailytodo.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dailytodo.viewmodel.TaskViewModel
import com.example.dailytodo.ui.CompletedScreen
import com.example.dailytodo.ui.MainScreen
import com.example.dailytodo.ui.calendar.CalendarScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: TaskViewModel = viewModel()

    NavHost(navController = navController, startDestination = "main") {

        composable("main") {
            MainScreen(
                viewModel = viewModel,
                onCompletedClick = { navController.navigate("completed") },
                onCalendarClick = { navController.navigate("calendar") }
            )
        }

        composable("completed") {
            CompletedScreen(
                viewModel = viewModel,
                navController = navController
            )
        }

        composable("calendar") {
            CalendarScreen(
                viewModel = viewModel,
                navController = navController
            )
        }
    }
}
