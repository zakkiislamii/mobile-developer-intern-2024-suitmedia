package com.example.mobile_developer_intern_2024_suitmedia.api.apiService

import com.example.mobile_developer_intern_2024_suitmedia.api.apiResponse.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApiService {
    @GET("users")
    suspend fun getUsers(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 10
    ): UserResponse
}