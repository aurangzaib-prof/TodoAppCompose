package com.example.todoapp.ui.presentation.task_screen

import androidx.lifecycle.viewModelScope
import com.example.todoapp.base.BaseViewModel
import com.example.todoapp.data.local.room.todo_database.TodoEntity
import com.example.todoapp.domain.usecase.AddTodoUseCase
import com.example.todoapp.ui.presentation.todo.TodoEffect
import com.example.todoapp.ui.presentation.todo.TodoIntent
import com.example.todoapp.ui.presentation.todo.TodoState
import kotlinx.coroutines.launch

class TodoViewModel(
    private val addTodoUseCase: AddTodoUseCase
) : BaseViewModel<TodoState, TodoIntent, TodoEffect>(
    TodoState()
) {

    override fun onIntent(intent: TodoIntent) {

        when (intent) {

            is TodoIntent.TitleChanged -> {
                updateState {
                    it.copy(
                        title = intent.title
                    )
                }
            }


            is TodoIntent.DescriptionChanged -> {
                updateState {
                    it.copy(
                        description = intent.description
                    )
                }
            }


            is TodoIntent.CompletedChanged -> {
                updateState {
                    it.copy(
                        isCompleted = intent.isCompleted
                    )
                }
            }


            is TodoIntent.DateSelected -> {
                updateState {
                    it.copy(
                        selectedDate = intent.date
                    )
                }
            }


            is TodoIntent.TimeSelected -> {
                updateState {
                    it.copy(
                        selectedTime = intent.time
                    )
                }
            }


            TodoIntent.SaveTodo -> {
                saveTodo()
            }


            TodoIntent.Cancel -> {
                updateState {
                    TodoState()
                }
            }
        }
    }


    private fun saveTodo() {

        val todo = TodoEntity(
            title = currentState.title,
            description = currentState.description,
            isCompleted = currentState.isCompleted,
            date = currentState.selectedDate,
            time = currentState.selectedTime
        )


        viewModelScope.launch {

            addTodoUseCase(todo)


            sendEffect(
                TodoEffect.ShowToast(
                    "Todo saved successfully"
                )
            )
        }
    }
}