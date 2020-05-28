package com.example.android.movies.data.local

import androidx.room.TypeConverter
import com.example.android.movies.presentation.MovieStatus
import com.example.android.movies.presentation.MovieStatus.*

class MovieStateConverter {

    @TypeConverter
    fun fromMovieStateToString(movieState: MovieStatus) = movieState.name

    @TypeConverter
    fun fromStringToMovieState(name: String) = when (name) {
        GUESSED.name -> GUESSED
        OPEN.name -> OPEN
        CLOSED.name -> CLOSED
        else -> CLOSED
    }
}