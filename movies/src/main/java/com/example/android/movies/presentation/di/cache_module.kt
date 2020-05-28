package com.example.android.movies.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.android.movies.data.local.MoviesDatabase
import org.koin.dsl.module

private const val DATABASE_NAME = "movies.db"
private const val DATABASE_FILE_PATH = "database/movie.db"

@Volatile
private var INSTANCE: MoviesDatabase? = null

private fun database(application: Application): MoviesDatabase {
    if (INSTANCE == null) {
        synchronized(MoviesDatabase::class.java) {
            if (INSTANCE == null) {
                INSTANCE =
                    Room.databaseBuilder(application, MoviesDatabase::class.java, DATABASE_NAME)
                        .createFromAsset(DATABASE_FILE_PATH)
                        .build()
            }
        }
    }
    return INSTANCE!!
}

private fun movieDao(database: MoviesDatabase) = database.movieDao()
private fun levelDao(database: MoviesDatabase) = database.levelDao()

val moviesCacheModule = module {
    single { database(application = get()) }
    single { movieDao(database = get()) }
    single { levelDao(database = get()) }
}