package com.example.todoapp.domain.model

data class Todo(

    val id: Int,

    val title: String,

    val description: String,

    val isCompleted: Boolean,

    val date: Long?,

    val time: String?
)