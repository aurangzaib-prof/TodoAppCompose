package com.example.todoapp.base

import kotlinx.coroutines.flow.StateFlow

interface UiState
interface UiIntent
interface UiEffect

interface MviViewModel<S : UiState, I : UiIntent, E : UiEffect> {
    val uiState: StateFlow<S>
    fun onIntent(intent: I)
}
