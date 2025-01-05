package com.example.mobile_developer_intern_2024_suitmedia.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_developer_intern_2024_suitmedia.api.apiService.UserApiService
import com.example.mobile_developer_intern_2024_suitmedia.models.User
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class UserViewModel : ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    private var currentPage = 1
    private var isLastPage = false

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in/api/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
    private val apiService = retrofit.create(UserApiService::class.java)

    init {
        getUsers(isRefresh = true)
    }

    fun getUsers(isRefresh: Boolean = false) {
        if (isRefresh) {
            currentPage = 1
            isLastPage = false
        }

        if (isLastPage && !isRefresh) return

        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = apiService.getUsers(page = currentPage)
                if (isRefresh) {
                    _users.value = response.data
                } else {
                    _users.value = _users.value.orEmpty() + response.data
                }
                isLastPage = response.page >= response.total_pages
                currentPage++
                _error.value = null
            } catch (e: Exception) {
                _error.value = e.message
                if (isRefresh) {
                    _users.value = emptyList()
                }
            } finally {
                _isLoading.value = false
            }
        }
    }
}