package com.example.android.movies.data.local.levels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "levels")
data class LevelDb(
    @PrimaryKey val id: Long,
    val passPercentage: Long = 0L
)