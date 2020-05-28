package com.example.android.movies.data.local.levels

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [LevelDb::class], version = 1, exportSchema = false)
abstract class LevelDatabase : RoomDatabase() {

    abstract fun levelDao(): LevelDao
}