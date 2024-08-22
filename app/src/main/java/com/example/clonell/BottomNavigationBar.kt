package com.example.clonell

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController

@Composable
fun BottomNavigationBar(navController: NavController) {
    var selectedIndex by rememberSaveable {
        mutableIntStateOf(1)
    }
    NavigationBar {
        listItems.forEachIndexed { index, item ->
            NavigationBarItem(selected = selectedIndex == index,
                onClick = {
                    selectedIndex = index
                    navController.navigate(listItems[index].route) {
                        popUpTo(Screen2.route)
                        launchSingleTop = true
                    }
                }, icon = {
                    Icon(
                        imageVector = if (index == selectedIndex) {
                            listItems[index].selectedIcon
                        } else {
                            listItems[index].unselectedIcon
                        }, contentDescription = listItems[index].description
                    )
                },
                label = {
                    Text(text = listItems[index].title)
                },
                alwaysShowLabel = false
            )
        }
    }
}

data class Items(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val description: String
)

val listItems = listOf<Items>(
    Items(
        "Setting",
        "Setting",
        Icons.Filled.Settings,
        Icons.Outlined.Settings,
        "Settings"
    ),
    Items(
        "Home",
        "Home",
        Icons.Filled.Home,
        Icons.Outlined.Home,
        "Home"
    ),
    Items(
        "Email",
        "Email",
        Icons.Filled.Email,
        Icons.Outlined.Email,
        "Email"
    )
)