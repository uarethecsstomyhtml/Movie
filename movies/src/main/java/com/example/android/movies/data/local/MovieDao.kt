package com.example.android.movies.data.local

import androidx.room.*
import com.example.android.movies.presentation.MovieDbList
import com.example.android.movies.presentation.MovieStatus

@Dao
interface MovieDao {

    @Query("SELECT status FROM movie WHERE id=:id")
    suspend fun getStateById(id: Long): MovieStatus

    @Query("SELECT * FROM movie")
    suspend fun getAll(): MovieDbList

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: MovieDbList)

    @Update
    suspend fun update(item: MovieDb)
}