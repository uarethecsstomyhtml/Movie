package com.android.example.guessmoviebymusic.di

import androidx.room.*
import com.android.example.guessmoviebymusic.`typealias`.LevelDbList
import com.android.example.guessmoviebymusic.levels.data.db.LevelDb

@Dao
interface LevelDao {

    @Query("SELECT passPercentage FROM level WHERE id=:id")
    suspend fun getPassPercentageById(id: Long): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(list: LevelDbList)

    @Update
    suspend fun update(item: LevelDb)

}