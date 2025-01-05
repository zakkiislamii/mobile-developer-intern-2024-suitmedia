package com.example.mobile_developer_intern_2024_suitmedia.view.screen.firstScreen.components.body

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mobile_developer_intern_2024_suitmedia.R
import com.example.mobile_developer_intern_2024_suitmedia.view.screen.firstScreen.components.button.FirstScreenButton
import com.example.mobile_developer_intern_2024_suitmedia.view.screen.firstScreen.components.field.FirstScreenField

@Composable
fun FirstScreenBody(
    firstScreenField: FirstScreenField,
    firstScreenButton: FirstScreenButton,
    name: String,
    palindrome: String,
    onNameChange: (String) -> Unit,
    onPalindromeChange: (String) -> Unit,
    onCheckClick: () -> Unit,
    onNextClick: () -> Unit,
) {
    Column {
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(150.dp)
                .clip(CircleShape)
                .background(color = Color(0xFF98c7cd))
                .border(2.dp, Color.Transparent, CircleShape)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.useraddplus),
                contentDescription = "Default Profile",
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.Center),
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        firstScreenField.NameField(
            value = name,
            onValueChange = onNameChange
        )
        firstScreenField.PalindromeField(
            value = palindrome,
            onValueChange = onPalindromeChange
        )
        Spacer(modifier = Modifier.height(24.dp))
        firstScreenButton.CheckButton(onClick = onCheckClick)
        firstScreenButton.NextButton(onClick = onNextClick)
    }
}