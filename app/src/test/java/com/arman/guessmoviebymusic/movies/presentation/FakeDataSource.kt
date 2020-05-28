package com.arman.guessmoviebymusic.movies.presentation

import com.arman.guessmoviebymusic.base.presentation.MovieDTOList
import com.arman.guessmoviebymusic.base.presentation.MovieDbList
import com.arman.guessmoviebymusic.base.presentation.MovieState
import com.arman.guessmoviebymusic.movies.data.db.MovieDb
import com.arman.guessmoviebymusic.movies.domain.datasource.MoviesDataSource
import com.arman.guessmoviebymusic.movies.domain.usecase.GetMoviesByLevelUseCase
import com.arman.guessmoviebymusic.movies.entity.MovieDTO

class FakeDataSource(
    var remoteMovies: MutableList<MovieDTO>? = mutableListOf(),
    var localMovies: MutableList<MovieDb>? = mutableListOf()
) : MoviesDataSource {

    override suspend fun getAll(): MovieDbList {
        return localMovies ?: listOf()
    }

    override suspend fun getAllByLevel(params: GetMoviesByLevelUseCase.Params): MovieDTOList {
        return remoteMovies as MovieDTOList
    }

    override suspend fun insertAll(movies: MovieDbList) {
        this.localMovies?.addAll(movies)
    }

    override suspend fun getStateById(id: Long): MovieState {
        return localMovies?.find { it.id == id }?.state ?: MovieState.OPEN
    }

}