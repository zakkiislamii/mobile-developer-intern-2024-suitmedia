package com.example.mobile_developer_intern_2024_suitmedia.screen.firstScreen.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobile_developer_intern_2024_suitmedia.contracts.button.Button
import com.example.mobile_developer_intern_2024_suitmedia.ui.theme.ButtonColor
import com.example.mobile_developer_intern_2024_suitmedia.ui.theme.Mobiledeveloperintern2024suitmediaTheme

class FirstScreenButton : Button {
    @Composable
    override fun CreateButton(
        text: String,
        backgroundColor: Color,
        textColor: Color,
        borderColor: Color,
        textStyle: TextStyle,
        fontSize: Int,
        onClick: () -> Unit,
    ) {
        androidx.compose.material3.Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = backgroundColor,
                contentColor = textColor
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp, 5.dp, 30.dp, 5.dp),
            border = BorderStroke(1.dp, borderColor)
        ) {
            Text(
                text = text,
                fontSize = fontSize.sp,
                style = textStyle
            )
        }
    }

    @Composable
    fun CheckButton(onClick: () -> Unit) {
        CreateButton(
            text = "CHECK",
            backgroundColor = ButtonColor,
            textColor = Color.White,
            textStyle = MaterialTheme.typography.titleMedium,
            fontSize = 14,
            borderColor = Color.Transparent,
            onClick = onClick
        )
    }

    @Composable
    fun NextButton(onClick: () -> Unit) {
        CreateButton(
            text = "NEXT",
            backgroundColor = ButtonColor,
            textColor = Color.White,
            textStyle = MaterialTheme.typography.titleMedium,
            fontSize = 14,
            borderColor = Color.Transparent,
            onClick = onClick
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun FirstScreenButtonPreview() {
        Mobiledeveloperintern2024suitmediaTheme {
            Column {
                FirstScreenButton().CheckButton {}
                FirstScreenButton().NextButton {}
            }
        }
    }
}