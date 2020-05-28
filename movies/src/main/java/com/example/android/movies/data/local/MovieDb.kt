package com.example.android.movies.data.local

import androidx.room.*
import com.example.android.movies.presentation.MovieStatus

@Entity(tableName = "movie")
data class MovieDb(
    @PrimaryKey
    val id: Long,
    val status: MovieStatus = MovieStatus.CLOSED
)