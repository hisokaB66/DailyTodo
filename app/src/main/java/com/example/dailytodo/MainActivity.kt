package com.example.dailytodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.dailytodo.ui.theme.DailyTodoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DailyTodoTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFFFF8E7)) {
                    AppNavigation()  // Navigation 호출
                }
            }
        }
    }
}
