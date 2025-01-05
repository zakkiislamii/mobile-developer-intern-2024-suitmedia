package com.example.mobile_developer_intern_2024_suitmedia.contracts.fields

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.VisualTransformation

interface Field {
    @Composable
    fun CreateField(
        value: String,
        onValueChange: (String) -> Unit,
        label: String,
        visualTransformation: VisualTransformation,
    )
}