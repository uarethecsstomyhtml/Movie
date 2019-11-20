package com.android.example.guessmoviebymusic.di

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.example.guessmoviebymusic.levels.data.db.LevelDb
import com.android.example.guessmoviebymusic.movies.data.db.MovieDb

@Database(entities = [LevelDb::class, MovieDb::class], version = 1 ,exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun levelDao(): LevelDao
    abstract fun movieDao(): MovieDao

}