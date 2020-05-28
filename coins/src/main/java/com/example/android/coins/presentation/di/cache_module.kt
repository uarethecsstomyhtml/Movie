package com.example.android.coins.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.android.coins.data.local.CoinsDatabase
import com.example.android.coins.data.repository.DefaultCoinsRepository
import com.example.android.coins.domain.repository.CoinsRepository
import org.koin.dsl.module


private const val DATABASE_NAME = "coins.db"

@Volatile
private var INSTANCE: CoinsDatabase? = null

private fun database(application: Application): CoinsDatabase {
    if (INSTANCE == null) {
        synchronized(CoinsDatabase::class.java) {
            if (INSTANCE == null) {
                INSTANCE =
                    Room.databaseBuilder(application, CoinsDatabase::class.java, DATABASE_NAME)
//                    .createFromAsset("database/movie.db")
                        .build()
            }
        }
    }
    return INSTANCE!!
}

private fun coinsDao(database: CoinsDatabase) = database.coinsDao()

val coinsCacheModule = module {
    single { database(application = get()) }
    single { coinsDao(database = get()) }
}