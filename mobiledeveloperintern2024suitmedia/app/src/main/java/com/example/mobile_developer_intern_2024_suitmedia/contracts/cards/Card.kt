package com.example.mobile_developer_intern_2024_suitmedia.contracts.cards

import androidx.compose.runtime.Composable

interface Card<T> {
    @Composable
    fun CreateCard(
        item: T,
        onClick: () -> Unit,
    )
}