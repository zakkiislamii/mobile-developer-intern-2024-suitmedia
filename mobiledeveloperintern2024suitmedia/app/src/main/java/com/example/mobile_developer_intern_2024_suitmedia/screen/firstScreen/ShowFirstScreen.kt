package com.example.mobile_developer_intern_2024_suitmedia.screen.firstScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

class ShowFirstScreen {
    @Composable
    fun FirstScreen(navController:NavController) {
        Text(text = "this is first screen")
    }
}