package com.example.mobile_developer_intern_2024_suitmedia.view.screen.secondScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mobile_developer_intern_2024_suitmedia.nav.Screen
import com.example.mobile_developer_intern_2024_suitmedia.view.screen.secondScreen.components.button.SecondScreenButton
import com.example.mobile_developer_intern_2024_suitmedia.view.screen.secondScreen.components.header.SecondScreenHeader

@Composable
fun ShowSecondScreen(navController: NavController) {
    val name =
        navController.currentBackStackEntry?.savedStateHandle?.get<String>("selectedUser") ?: ""

    val secondScreenButton = SecondScreenButton()
    Scaffold(
        modifier = Modifier.windowInsetsPadding(WindowInsets.safeDrawing),
        topBar = {
            SecondScreenHeader {
                navController.navigate(Screen.FirstScreen.route)
            }
        },
        bottomBar = {
            secondScreenButton.ChooseButton {
                navController.navigate(Screen.ThirdScreen.route)
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(horizontal = 16.dp, vertical = 24.dp)
            ) {
                Text(
                    text = "Welcome",
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = 4.dp),
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = "Selected User Name",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
}