package com.example.android.movies.data.remote

import com.example.android.movies.domain.datasource.MoviesDataSource
import com.example.android.movies.domain.usecase.GetMoviesByLevelUseCase
import com.example.android.movies.presentation.MovieDbList
import com.example.android.movies.presentation.MovieDtoList
import com.example.android.movies.presentation.MovieStatus

class MoviesRemoteDataSource(private val api: MoviesApi) : MoviesDataSource {

    override suspend fun getAllByLevel(params: GetMoviesByLevelUseCase.Params): MovieDtoList {
        return api.getMoviesByLevel().data
    }

    override suspend fun getAll(): MovieDbList {
        throw Exception("NO-OP")
    }

    override suspend fun insertAll(movies: MovieDbList) {
        throw Exception("NO-OP")
    }

    override suspend fun getStatusById(id: Long): MovieStatus {
        throw Exception("NO-OP")
    }

}