package com.example.mobile_developer_intern_2024_suitmedia.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mobile_developer_intern_2024_suitmedia.screen.firstScreen.FirstScreen
import com.example.mobile_developer_intern_2024_suitmedia.screen.secondScreen.SecondScreen
import com.example.mobile_developer_intern_2024_suitmedia.screen.thirdScreen.ShowThirdScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.FirstScreen.route) {
        composable(route = Screen.FirstScreen.route) {
            FirstScreen(navController = navController)
        }
        composable(
            route = Screen.SecondScreen.route,
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            SecondScreen(navController = navController, name = name)
        }
        composable(route = Screen.ThirdScreen.route) {
            ShowThirdScreen().ThirdScreen(navController = navController)
        }
    }

}