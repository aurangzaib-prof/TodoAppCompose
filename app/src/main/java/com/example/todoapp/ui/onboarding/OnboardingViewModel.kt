package com.example.todoapp.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.ui.onboarding.mvi.OnboardingEffect
import com.example.todoapp.ui.onboarding.mvi.OnboardingIntent
import com.example.todoapp.ui.onboarding.mvi.OnboardingState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class OnboardingViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(OnboardingState())
    val uiState: StateFlow<OnboardingState> = _uiState.asStateFlow()

    private val _effect = MutableSharedFlow<OnboardingEffect>()
    val effect: SharedFlow<OnboardingEffect> = _effect.asSharedFlow()

    fun onIntent(intent: OnboardingIntent) {
        when (intent) {
            OnboardingIntent.NextPage -> handleNextPage()
        }
    }

    private fun handleNextPage() {
        if (_uiState.value.currentPage < 3) {
            _uiState.update { it.copy(currentPage = it.currentPage + 1) }
        } else {
            viewModelScope.launch {
                _effect.emit(OnboardingEffect.NavigateToLogin)
            }
        }
    }
}
