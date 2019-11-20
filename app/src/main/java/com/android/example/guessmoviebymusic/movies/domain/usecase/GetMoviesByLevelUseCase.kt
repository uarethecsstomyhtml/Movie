package com.android.example.guessmoviebymusic.movies.domain.usecase

import com.android.example.guessmoviebymusic.`typealias`.BaseGetMoviesByLevelUseCase
import com.android.example.guessmoviebymusic.base.domain.BaseUseCase
import com.android.example.guessmoviebymusic.base.domain.Either
import com.android.example.guessmoviebymusic.base.domain.Failure
import com.android.example.guessmoviebymusic.`typealias`.MovieList
import com.android.example.guessmoviebymusic.`typealias`.MovieListEither
import com.android.example.guessmoviebymusic.movies.domain.repository.MoviesRepository


class GetMoviesByLevelUseCase(private val repository: MoviesRepository) : BaseGetMoviesByLevelUseCase() {


    override suspend fun run(params: Params): MovieListEither {
        return try {
            val levels = repository.getAllByLevel(params)
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