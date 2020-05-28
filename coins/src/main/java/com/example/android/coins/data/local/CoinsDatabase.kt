package com.example.android.coins.data.local

import androidx.room.*

@Database(entities = [CoinsDb::class], version = 1, exportSchema = false)
abstract class CoinsDatabase : RoomDatabase() {

    abstract fun coinsDao(): CoinsDao
}