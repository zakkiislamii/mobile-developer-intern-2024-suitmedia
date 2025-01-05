package com.example.mobile_developer_intern_2024_suitmedia.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mobile_developer_intern_2024_suitmedia.screen.firstScreen.ShowFirstScreen
import com.example.mobile_developer_intern_2024_suitmedia.screen.secondScreen.ShowSecondScreen
import com.example.mobile_developer_intern_2024_suitmedia.screen.thirdScreen.ShowThirdScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.FirstScreen.route) {
        composable(route = Screen.FirstScreen.route) {
            ShowFirstScreen().FirstScreen(navController = navController)
        }
        composable(route = Screen.SecondScreen.route) {
            ShowSecondScreen().SecondScreen(navController = navController)
        }
        composable(route = Screen.ThirdScreen.route) {
            ShowThirdScreen().ThirdScreen(navController = navController)
        }
    }

}