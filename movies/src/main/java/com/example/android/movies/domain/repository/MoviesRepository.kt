package com.example.android.movies.domain.repository

import com.example.android.movies.domain.usecase.GetMoviesByLevelUseCase
import com.example.android.movies.presentation.MovieDbList
import com.example.android.movies.presentation.MovieDtoList

interface MoviesRepository {

    suspend fun getAllByLevel(params: GetMoviesByLevelUseCase.Params): MovieDtoList

    suspend fun insert(movies: MovieDbList)

    suspend fun getAll(): MovieDbList
}