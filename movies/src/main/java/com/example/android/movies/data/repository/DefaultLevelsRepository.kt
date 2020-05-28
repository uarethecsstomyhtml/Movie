package com.example.android.movies.data.repository

import com.example.android.movies.R
import com.example.android.movies.data.local.levels.LevelDao
import com.example.android.movies.data.remote.levels.LevelsApi
import com.example.android.movies.domain.repository.LevelsRepository
import com.example.android.movies.entity.LevelDto
import com.example.android.movies.presentation.ui.levels.LevelDtoList

class DefaultLevelsRepository(
    private val levelsApi: LevelsApi,
    private val levelDao: LevelDao
) : LevelsRepository {

    val list = listOf(
        LevelDto(
            id = 1,
            name = "Новичок",
            bgColor = "#64B5F6",
            imgRes = R.drawable.level1,
            passPercentage = 0
        ),
        LevelDto(
            id = 2,
            name = "Любитель",
            bgColor = "#4DB6AC",
            imgRes = R.drawable.level2,
            passPercentage = 0
        ),
        LevelDto(
            id = 3,
            name = "Профессионал",
            bgColor = "#7986CB",
            imgRes = R.drawable.level3,
            passPercentage = 0
        ),
        LevelDto(
            id = 4,
            name = "Киноман",
            bgColor = "#E57373",
            imgRes = R.drawable.level4,
            passPercentage = 0
        ),
        LevelDto(
            id = 5,
            name = "Кинокритик",
            bgColor = "#9575CD",
            imgRes = R.drawable.level5,
            passPercentage = 0
        )
    )


//    override suspend fun getAll(): LevelDtoList {
//        val levelsRemote = api.getLevels().data
//        Timber.d("getAll, levelsRemote: $levelsRemote")
//
//        val levelsDb = levelsRemote.map { LevelDb(it.id) }
//        dao.insert(levelsDb)
//
//        levelsRemote.map { it.passPercentage = dao.getPassPercentageById(it.id) }
//
//        return levelsRemote
//    }

    override suspend fun getAll(): LevelDtoList {

        return list
    }
}