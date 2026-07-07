package com.example.todoapp.ui.presentation.todo

import com.example.todoapp.base.UiEffect

sealed interface TodoEffect : UiEffect {
    data class ShowToast(val message: String) : TodoEffect
}