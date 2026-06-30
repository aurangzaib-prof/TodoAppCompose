package com.example.todoapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import com.example.todoapp.R
import com.example.todoapp.ui.components.CustomSearchBar

@Composable
fun TasksScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.bg_top_color),
                        colorResource(id = R.color.bg_bottom_color)
                    )
                )
            ),
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            CustomSearchBar(
                query = "",
                onQueryChange = {
                }
            )
        }
    }
}