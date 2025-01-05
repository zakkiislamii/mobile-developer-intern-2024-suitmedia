package com.example.mobile_developer_intern_2024_suitmedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.mobile_developer_intern_2024_suitmedia.nav.AppNavHost
import com.example.mobile_developer_intern_2024_suitmedia.ui.theme.Mobiledeveloperintern2024suitmediaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mobiledeveloperintern2024suitmediaTheme {
                val navController = rememberNavController()
                AppNavHost(navController = navController)
            }
        }
    }
}
