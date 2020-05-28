package com.example.android.movies.data.local

import androidx.room.*
import com.example.android.movies.data.local.levels.LevelDao
import com.example.android.movies.data.local.levels.LevelDb

@Database(entities = [MovieDb::class, LevelDb::class], version = 1, exportSchema = false)
@TypeConverters(MovieStateConverter::class)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun levelDao(): LevelDao
}