package com.example.todoapp.ui.presentation.todo

import com.example.todoapp.base.UiState

data class TodoState(
    val title: String = "",
    val description: String = "",
    val isCompleted: Boolean = false,
    val selectedDate: Long? = null,
    val selectedTime: String? = null
) : UiState