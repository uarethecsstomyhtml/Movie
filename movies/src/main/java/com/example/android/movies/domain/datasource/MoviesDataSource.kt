package com.example.android.movies.domain.datasource

import com.example.android.movies.domain.usecase.GetMoviesByLevelUseCase
import com.example.android.movies.presentation.MovieDbList
import com.example.android.movies.presentation.MovieDtoList
import com.example.android.movies.presentation.MovieStatus

interface MoviesDataSource {

    suspend fun getAll(): MovieDbList

    suspend fun getAllByLevel(params: GetMoviesByLevelUseCase.Params): MovieDtoList

    suspend fun getStatusById(id: Long): MovieStatus

    suspend fun insertAll(movies: MovieDbList)

}