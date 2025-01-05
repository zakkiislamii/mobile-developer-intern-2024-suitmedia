package com.example.mobile_developer_intern_2024_suitmedia.screen.firstScreen.components.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.mobile_developer_intern_2024_suitmedia.contracts.field.Field

class FirstScreenField : Field {
    @Composable
    override fun CreateField(
        value: String,
        onValueChange: (String) -> Unit,
        label: String,
        visualTransformation: VisualTransformation,
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = label, color = Color.Black) },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.White,
                focusedBorderColor = Color.White,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedContainerColor = if (value.isNotEmpty()) Color.Transparent else Color.Transparent,
                unfocusedContainerColor = if (value.isNotEmpty()) Color.Transparent else Color.White,
            ),
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 5.dp, 20.dp, 5.dp)
        )
    }

    @Composable
    fun NameField(
        value: String,
        onValueChange: (String) -> Unit,
    ) = CreateField(
        value = value,
        onValueChange = onValueChange,
        label = "Name",
        visualTransformation = VisualTransformation.None,
    )

    @Composable
    fun PalindromeField(
        value: String,
        onValueChange: (String) -> Unit,
    ) = CreateField(
        value = value,
        onValueChange = onValueChange,
        label = "Palindrome",
        visualTransformation = VisualTransformation.None,
    )
}