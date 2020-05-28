package com.example.android.coins.data.local

import androidx.room.Dao
import androidx.room.Query


@Dao
interface CoinsDao {

    @Query("SELECT amount FROM coins WHERE id=1")
    suspend fun getAmount(): Int

    @Query("UPDATE coins SET amount=:amount WHERE id=1")
    suspend fun updateAmount(amount: Int)
}