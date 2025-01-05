package com.example.mobile_developer_intern_2024_suitmedia.api.apiResponse

import com.example.mobile_developer_intern_2024_suitmedia.models.User

data class UserResponse(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<User>,
    val support: Support,
)
