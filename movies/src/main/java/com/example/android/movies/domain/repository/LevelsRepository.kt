package com.example.android.movies.domain.repository

import com.example.android.movies.presentation.ui.levels.LevelDtoList


interface LevelsRepository {

    suspend fun getAll(): LevelDtoList
}