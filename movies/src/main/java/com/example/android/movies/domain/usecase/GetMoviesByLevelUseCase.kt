package com.example.android.movies.domain.usecase

import com.example.android.movies.domain.repository.MoviesRepository
import com.example.android.movies.presentation.BaseGetMoviesByLevelUseCase
import com.example.android.movies.presentation.MovieDtoListEither
import com.example.android.network.domain.Either
import com.example.android.network.domain.Failure


class GetMoviesByLevelUseCase(private val moviesRepository: MoviesRepository) :
    BaseGetMoviesByLevelUseCase() {


    override suspend fun run(params: Params): MovieDtoListEither {
        return try {
            val levels = moviesRepository.getAllByLevel(params)
            Either.Right(levels)
        } catch (e: Exception) {
            e.printStackTrace()
            Either.Left(Failure.FeatureFailure(e))
        }
    }

    data class Params(
        val levelId: Long
    )
}