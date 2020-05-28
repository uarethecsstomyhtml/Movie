package com.example.android.coins.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coins")
data class CoinsDb(
    @PrimaryKey
    val id: Int,
    val amount: Int
)