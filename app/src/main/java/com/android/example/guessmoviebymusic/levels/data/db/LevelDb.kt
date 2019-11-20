package com.android.example.guessmoviebymusic.levels.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "level")
data class LevelDb(
    @PrimaryKey val id: Long,
    val passPercentage: Long = 0L
)