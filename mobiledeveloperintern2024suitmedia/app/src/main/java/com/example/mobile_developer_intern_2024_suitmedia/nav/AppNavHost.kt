package com.example.mobile_developer_intern_2024_suitmedia.nav

import com.example.mobile_developer_intern_2024_suitmedia.view.screen.thirdScreen.ShowThirdScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mobile_developer_intern_2024_suitmedia.view.screen.firstScreen.ShowFirstScreen
import com.example.mobile_developer_intern_2024_suitmedia.view.screen.secondScreen.ShowSecondScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.FirstScreen.route) {
        composable(route = Screen.FirstScreen.route) {
            ShowFirstScreen(navController = navController)
        }
        composable(route = Screen.SecondScreen.route) {
            ShowSecondScreen(
                navController = navController
            )
        }
        composable(route = Screen.ThirdScreen.route) {
            ShowThirdScreen(navController = navController)
        }
    }
}