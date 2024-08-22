package com.example.clonell

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val snackState = remember {
        SnackbarHostState()
    }
    val currentDestinations = navController.currentBackStackEntryAsState().value?.destination?.route
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            CTopAppBar(scaffoldState, scope)
        },
        drawerContent = {
            CustomDrawer()
        },
        bottomBar = {
            if (currentDestinations != Detail.route) {
                BottomNavigationBar(navController = navController)
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = snackState)
        }
    ) { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {
            NavHost(navController = navController, startDestination = Screen2.route) {
                composable(Screen1.route) {
                    Screen1()
                }
                composable(Screen2.route) {
                    MainScreen(snackState, scope, navController)
                }
                composable(Screen3.route) {
                    Screen3()
                }
                composable(Detail.route + "/{${Detail.argDishId}}", arguments = listOf(
                    navArgument(Detail.argDishId) {
                        type = NavType.IntType
                    }
                )) {
                    val id = requireNotNull(it.arguments?.getInt(Detail.argDishId))
                    DetailScreen(id = id)
                }
            }

        }
    }
}