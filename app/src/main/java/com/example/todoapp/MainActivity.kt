package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.base.*
import com.example.todoapp.ui.home.TasksScreen
import com.example.todoapp.ui.login.LoginScreen
import com.example.todoapp.ui.onboarding.OnboardingScreen
import com.example.todoapp.ui.signup.SignupScreen
import com.example.todoapp.ui.splash.SplashScreen
import com.example.todoapp.ui.theme.TodoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoAppTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Splash,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable<Splash> {
                            SplashScreen(navController)
                        }
                        composable<OnboardingOne> {
                            OnboardingScreen(navController)
                        }
                        composable<Login> {
                            LoginScreen(navController)
                        }
                        composable<Signup> {
                            SignupScreen(navController)
                        }
                        composable<Home> {
                            TasksScreen(navController)
                        }
                    }
                }
            }
        }
    }
}
