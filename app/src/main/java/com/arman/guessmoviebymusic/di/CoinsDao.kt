package com.arman.guessmoviebymusic.di

import androidx.room.*
import com.arman.guessmoviebymusic.base.presentation.MovieDbList
import com.arman.guessmoviebymusic.levels.data.db.CoinsDb
import com.arman.guessmoviebymusic.movies.data.db.MovieDb

@Dao
interface CoinsDao {

    @Query("SELECT amount FROM coins WHERE id=1")
    suspend fun getAmount(): Int

    @Query("UPDATE coins SET amount=:amount WHERE id=1")
    suspend fun updateAmount(amount: Int)
}