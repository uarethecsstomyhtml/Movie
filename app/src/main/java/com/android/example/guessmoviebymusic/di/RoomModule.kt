package com.android.example.guessmoviebymusic.di

import android.app.Application
import androidx.room.Room
import com.android.example.guessmoviebymusic.BuildConfig.DATABASE_NAME
import org.koin.dsl.module


@Volatile
private var INSTANCE: MovieDatabase? = null

private val database =  fun(app: Application): MovieDatabase {
    if (INSTANCE == null) {
        synchronized(MovieDatabase::class.java) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(app, MovieDatabase::class.java, DATABASE_NAME).build()
            }
        }
    }
    return INSTANCE!!
}

private val levelDao =  fun(db: MovieDatabase) = db.levelDao()
private val movieDao =  fun(db: MovieDatabase) = db.movieDao()

internal val roomModule = module {
    single { database(get()) }
    single { levelDao(get()) }
    single { movieDao(get()) }
}