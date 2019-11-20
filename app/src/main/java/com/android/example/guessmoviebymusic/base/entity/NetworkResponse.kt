package com.android.example.guessmoviebymusic.base.entity


data class NetworkResponse<T> (
    val status: Int,
    val success: Boolean,
    val data: T
)