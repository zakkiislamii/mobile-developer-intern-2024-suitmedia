package com.example.mobile_developer_intern_2024_suitmedia.nav

sealed class Screen(val route: String) {
    data object FirstScreen : Screen("firstScreen")
    data object SecondScreen : Screen("secondScreen/{name}")
    data object ThirdScreen : Screen("thirdScreen")
}