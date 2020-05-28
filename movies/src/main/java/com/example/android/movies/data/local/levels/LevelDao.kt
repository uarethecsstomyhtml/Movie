package com.example.android.movies.data.local.levels

import androidx.room.*
import com.example.android.movies.presentation.ui.levels.LevelDbList


@Dao
interface LevelDao {

    @Query("SELECT passPercentage FROM levels WHERE id=:id")
    suspend fun getPassPercentageById(id: Long): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(list: LevelDbList)

    @Update
    suspend fun update(item: LevelDb)

}