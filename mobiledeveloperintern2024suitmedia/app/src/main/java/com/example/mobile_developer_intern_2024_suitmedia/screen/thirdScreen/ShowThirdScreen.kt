package com.example.mobile_developer_intern_2024_suitmedia.screen.thirdScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mobile_developer_intern_2024_suitmedia.nav.Screen
import com.example.mobile_developer_intern_2024_suitmedia.screen.thirdScreen.components.header.ThirdScreenHeader

class ShowThirdScreen {
    @Composable
    fun ThirdScreen(navController: NavController) {
        Scaffold(
            modifier = Modifier.windowInsetsPadding(
                WindowInsets.safeDrawing
            ),
            topBar = {
                ThirdScreenHeader {
                    navController.navigate(Screen.SecondScreen.route)
                }
            },
        ) { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Welcome")
            }
        }
    }
}