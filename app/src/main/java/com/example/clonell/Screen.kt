package com.example.clonell

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope

@Composable
fun Screen1() {
    Text(text = "Screen1", style = MaterialTheme.typography.h1)
}

@Composable
fun MainScreen(snackBarHostState: SnackbarHostState, scope: CoroutineScope, navController: NavController) {
    Column {
        UpperPanel(snackBarHostState, scope)
        LowerPanel(navController)
    }
}
@Composable
fun Screen3() {
    Text(text = "Screen3", style = MaterialTheme.typography.h1)
}