package com.android.example.guessmoviebymusic.movies.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieDb(
    @PrimaryKey val id: Long,
    val isGuessed: Boolean = false
)