package com.android.example.guessmoviebymusic.levels.data.repository

import com.android.example.guessmoviebymusic.`typealias`.LevelList
import com.android.example.guessmoviebymusic.di.LevelDao
import com.android.example.guessmoviebymusic.levels.data.db.LevelDb
import com.android.example.guessmoviebymusic.levels.data.remote.LevelsApi
import com.android.example.guessmoviebymusic.levels.domain.repository.LevelsRepository
import com.android.example.guessmoviebymusic.movies.data.db.MovieDb
import timber.log.Timber

class LevelsRepositoryImpl(
        private val api: LevelsApi,
        private val dao: LevelDao
): LevelsRepository {

    override suspend fun getAll(): LevelList {
        val levelsRemote = api.getLevels().data
        Timber.d("getAll, levelsRemote: $levelsRemote")

        val levelsDb = levelsRemote.map { LevelDb(it.id) }
        dao.insert(levelsDb)

        levelsRemote.map { it.passPercentage = dao.getPassPercentageById(it.id) }

        return levelsRemote
    }
}