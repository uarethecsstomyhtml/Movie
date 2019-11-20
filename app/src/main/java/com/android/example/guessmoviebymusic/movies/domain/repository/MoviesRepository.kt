package com.android.example.guessmoviebymusic.movies.domain.repository

import com.android.example.guessmoviebymusic.`typealias`.MovieList
import com.android.example.guessmoviebymusic.movies.domain.usecase.GetMoviesByLevelUseCase

interface MoviesRepository {

    suspend fun getAllByLevel(params: GetMoviesByLevelUseCase.Params): MovieList
}