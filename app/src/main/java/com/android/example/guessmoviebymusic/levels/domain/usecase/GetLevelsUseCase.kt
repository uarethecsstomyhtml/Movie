package com.android.example.guessmoviebymusic.levels.domain.usecase

import com.android.example.guessmoviebymusic.`typealias`.BaseGetLevelsUseCase
import com.android.example.guessmoviebymusic.base.domain.Either
import com.android.example.guessmoviebymusic.base.domain.Failure
import com.android.example.guessmoviebymusic.levels.domain.repository.LevelsRepository
import com.android.example.guessmoviebymusic.`typealias`.LevelListEither


class GetLevelsUseCase(private val repository: LevelsRepository) : BaseGetLevelsUseCase() {


    override suspend fun run(params: Params): LevelListEither {
        return try {
            val levels = repository.getAll()
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