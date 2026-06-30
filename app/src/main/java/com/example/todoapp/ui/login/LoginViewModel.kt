package com.example.todoapp.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.ui.login.mvi.LoginEffect
import com.example.todoapp.ui.login.mvi.LoginIntent
import com.example.todoapp.ui.login.mvi.LoginState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LoginState())
    val uiState: StateFlow<LoginState> = _uiState.asStateFlow()

    private val _effect = MutableSharedFlow<LoginEffect>()
    val effect: SharedFlow<LoginEffect> = _effect.asSharedFlow()

    fun onIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.EmailChanged -> {
                _uiState.update { it.copy(email = intent.email) }
            }
            LoginIntent.LoginClicked -> handleLogin()
            LoginIntent.SignupClicked -> {
                viewModelScope.launch { _effect.emit(LoginEffect.NavigateToSignup) }
            }
        }
    }

    private fun handleLogin() {
        viewModelScope.launch {
            _effect.emit(LoginEffect.NavigateToHome)
        }
    }
}
