package com.example.mobile_developer_intern_2024_suitmedia.view.screen.firstScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.mobile_developer_intern_2024_suitmedia.R
import com.example.mobile_developer_intern_2024_suitmedia.nav.Screen
import com.example.mobile_developer_intern_2024_suitmedia.view.screen.firstScreen.components.alert.PalindromeResultDialog
import com.example.mobile_developer_intern_2024_suitmedia.view.screen.firstScreen.components.body.FirstScreenBody
import com.example.mobile_developer_intern_2024_suitmedia.view.screen.firstScreen.components.button.FirstScreenButton
import com.example.mobile_developer_intern_2024_suitmedia.view.screen.firstScreen.components.field.FirstScreenField
import java.util.Locale

@Composable
fun ShowFirstScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var palindrome by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var isPalindromeResult by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    val firstScreenField = FirstScreenField()
    val firstScreenButton = FirstScreenButton()

    Scaffold(
        modifier = Modifier.windowInsetsPadding(WindowInsets.safeDrawing)
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.background_image),
                contentDescription = "Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                FirstScreenBody(
                    firstScreenField = firstScreenField,
                    firstScreenButton = firstScreenButton,
                    navController = navController,
                    name = name,
                    palindrome = palindrome,
                    onNameChange = { name = it },
                    onPalindromeChange = { palindrome = it },
                    onCheckClick = {
                        if (palindrome.trim().isEmpty()) {
                            dialogMessage = "Please enter a text to check"
                            isError = true
                            showDialog = true
                        } else {
                            isPalindromeResult = isPalindrome(palindrome)
                            dialogMessage =
                                if (isPalindromeResult) "is Palindrome" else "not palindrome"
                            isError = false
                            showDialog = true
                        }
                    },
                    onNextClick = {
                        if (name.trim().isEmpty()) {
                            dialogMessage = "Please enter your name"
                            isError = true
                            showDialog = true
                        } else {
                            navController.navigate(Screen.SecondScreen.route)
                            navController.getBackStackEntry(Screen.SecondScreen.route).savedStateHandle["selectedUser"] =
                                name
                        }
                    }
                )
            }
        }

        if (showDialog) {
            PalindromeResultDialog(
                message = dialogMessage,
                onDismiss = { showDialog = false }
            )
        }
    }
}

private fun isPalindrome(text: String): Boolean {
    val cleanText = text.lowercase(Locale.getDefault()).replace("\\s".toRegex(), "")
    return cleanText == cleanText.reversed()
}