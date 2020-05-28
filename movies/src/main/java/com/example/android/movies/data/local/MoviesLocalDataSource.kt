package com.example.android.movies.data.local

import com.example.android.movies.domain.datasource.MoviesDataSource
import com.example.android.movies.domain.usecase.GetMoviesByLevelUseCase
import com.example.android.movies.presentation.MovieDbList
import com.example.android.movies.presentation.MovieDtoList
import com.example.android.movies.presentation.MovieStatus

class MoviesLocalDataSource(private val dao: MovieDao) : MoviesDataSource {

    override suspend fun getAll(): MovieDbList {
        return dao.getAll()
    }

    override suspend fun getAllByLevel(params: GetMoviesByLevelUseCase.Params): MovieDtoList {
        throw Exception("NO-OP")
    }

    override suspend fun insertAll(movies: MovieDbList) {
        dao.insert(movies)
    }

    override suspend fun getStatusById(id: Long): MovieStatus {
        return dao.getStateById(id)
    }
}