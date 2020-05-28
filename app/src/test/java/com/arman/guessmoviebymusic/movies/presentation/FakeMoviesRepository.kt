package com.arman.guessmoviebymusic.movies.presentation

import com.arman.guessmoviebymusic.base.presentation.MovieDTOList
import com.arman.guessmoviebymusic.base.presentation.MovieDbList
import com.arman.guessmoviebymusic.base.presentation.MovieState
import com.arman.guessmoviebymusic.base.presentation.MovieState.OPEN
import com.arman.guessmoviebymusic.movies.domain.repository.MoviesRepository
import com.arman.guessmoviebymusic.movies.domain.usecase.GetMoviesByLevelUseCase
import com.arman.guessmoviebymusic.movies.entity.MovieDTO

class FakeMoviesRepository : MoviesRepository {


    val levels = listOf(MovieDTO(1, "1", "1", OPEN))

    override suspend fun getAllByLevel(params: GetMoviesByLevelUseCase.Params): MovieDTOList {
        return levels
    }

    override suspend fun insert(movies: MovieDbList) {

    }

    override suspend fun getAll(): MovieDbList {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}