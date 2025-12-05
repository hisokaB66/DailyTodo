package com.example.dailytodo.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.dailytodo.model.Todo

@Composable
fun TodoList(
    todos: List<Todo>,
    onToggleTodo: (Todo) -> Unit
) {
    Column {
        todos.forEach { todo ->
            TodoItem(todo = todo, onToggleTodo = onToggleTodo)
        }
    }
}
