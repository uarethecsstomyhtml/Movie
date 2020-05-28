package com.example.android.movies.entity

import com.example.android.movies.presentation.MovieStatus


data class MovieDto(
    val id: Long,
    val name: String,
    val answerLetters: String,
    var state: MovieStatus
)
