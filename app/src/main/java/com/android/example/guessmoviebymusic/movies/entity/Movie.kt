package com.android.example.guessmoviebymusic.movies.entity

import com.google.gson.annotations.Expose


data class Movie (
    val id: Long,
    val name: String,
    val answerLetters: String?,
    @Expose var isGuessed: Boolean
)
