package com.example.todoapp.di

import androidx.room.Room
import com.example.todoapp.data.local.datastore.PreferenceManager
import com.example.todoapp.data.local.room.auth_database.AuthDatabase
import com.example.todoapp.data.repository.AuthRepository
import com.example.todoapp.ui.presentation.login.LoginViewModel
import com.example.todoapp.ui.presentation.onboarding.OnboardingViewModel
import com.example.todoapp.ui.presentation.signup.SignupViewModel
import com.example.todoapp.ui.presentation.splash.SplashViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import androidx.datastore.preferences.preferencesDataStore
import com.example.todoapp.base.BaseViewModel
import com.example.todoapp.data.repository.TodoRepository
import com.example.todoapp.data.repository.TodoRepositoryImpl
import com.example.todoapp.domain.usecase.AddTodoUseCase
import com.example.todoapp.ui.presentation.task_screen.TodoViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf

private val android.content.Context.dataStore by preferencesDataStore(name = "settings")

val appModule = module {
    single { androidContext().dataStore }
    single { PreferenceManager(get()) }
    single {
        Room.databaseBuilder(
            androidContext(),
            AuthDatabase::class.java,
            "todo_db"
        ).build()
    }

    single { get<AuthDatabase>().userDao() }

    singleOf (::AuthRepository )

    viewModel { SplashViewModel(get()) }
    viewModel { OnboardingViewModel() }
    viewModel { LoginViewModel(get(), get()) }
    viewModelOf( ::LoginViewModel)
    viewModel { SignupViewModel(get(), get()) }
    viewModel { TodoViewModel(get()) }

    single<TodoRepository> {
        TodoRepositoryImpl(get())
    }

    factory {
        AddTodoUseCase(get())
    }
}
