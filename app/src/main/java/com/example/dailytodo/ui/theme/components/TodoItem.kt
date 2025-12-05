package com.example.dailytodo.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.dailytodo.model.Todo

@Composable
fun TodoItem(
    todo: Todo,
    onToggleTodo: (Todo) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Checkbox(
            checked = todo.isDone,
            onCheckedChange = { onToggleTodo(todo) }
        )
        Text(todo.title)
    }
}
