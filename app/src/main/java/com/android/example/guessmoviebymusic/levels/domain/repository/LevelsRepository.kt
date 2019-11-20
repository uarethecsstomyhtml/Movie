package com.android.example.guessmoviebymusic.levels.domain.repository

import com.android.example.guessmoviebymusic.`typealias`.LevelList

interface LevelsRepository {

    suspend fun getAll(): LevelList
}