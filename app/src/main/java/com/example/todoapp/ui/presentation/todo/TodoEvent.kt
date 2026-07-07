package com.example.todoapp.ui.presentation.todo

sealed class TodoEvent {

    data class TitleChanged(
        val value: String
    ) : TodoEvent()


    data class DescriptionChanged(
        val value: String
    ) : TodoEvent()


    data class DateSelected(
        val date: Long
    ) : TodoEvent()


    data class TimeSelected(
        val time: String
    ) : TodoEvent()


    data object SaveTodo : TodoEvent()
}