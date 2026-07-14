package com.example.todoapp.ui.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.todoapp.ui.navigation.BottomNavItem

import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp
import com.example.todoapp.ui.presentation.home.MainStates

@Composable
fun BottomBar(
    state: MainStates,
    onTabClicked: (BottomNavItem) -> Unit
) {


    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.TaskScreen,
        BottomNavItem.Calender,
        BottomNavItem.Settings,
    )

    NavigationBar(
        containerColor = Color.Transparent,
        contentColor = Color.White,
        tonalElevation = 0.dp
    ) {

        items.forEach { item ->

            NavigationBarItem(
                selected = item == state.selectedTab,

                onClick = {

                    onTabClicked(
                        item
                    )
                },

                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = Modifier.size(24.dp)
                    )
                },

                label = {
                    Text(item.title)
                }
            )
        }
    }
}