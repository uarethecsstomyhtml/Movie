package com.example.android.network.entity


data class NetworkResponse<T>(
    val status: Int,
    val success: Boolean,
    val data: T
)