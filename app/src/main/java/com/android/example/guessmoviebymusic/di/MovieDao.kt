package com.android.example.guessmoviebymusic.di

import androidx.room.*
import com.android.example.guessmoviebymusic.`typealias`.MovieDbList
import com.android.example.guessmoviebymusic.movies.data.db.MovieDb

@Dao
interface MovieDao {

    @Query("SELECT isGuessed FROM movie WHERE id=:id")
    suspend fun isGuessedById(id: Long): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: MovieDbList)

    @Update
    suspend fun update(item: MovieDb)
}