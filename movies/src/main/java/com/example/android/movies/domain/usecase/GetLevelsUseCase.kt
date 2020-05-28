package com.example.android.movies.domain.usecase

import com.example.android.movies.domain.repository.LevelsRepository
import com.example.android.movies.presentation.ui.levels.BaseGetLevelsUseCase
import com.example.android.movies.presentation.ui.levels.LevelDtoListEither
import com.example.android.network.domain.Either
import com.example.android.network.domain.Failure


class GetLevelsUseCase(private val levelsRepository: LevelsRepository) : BaseGetLevelsUseCase() {


    override suspend fun run(params: Params): LevelDtoListEither {
        return try {
            val levels = levelsRepository.getAll()
            Either.Right(levels)
        } catch (e: Exception) {
            e.printStackTrace()
            Either.Left(Failure.FeatureFailure(e))
        }
    }

    data class Params(
        val isRemote: Boolean = false
    )
}