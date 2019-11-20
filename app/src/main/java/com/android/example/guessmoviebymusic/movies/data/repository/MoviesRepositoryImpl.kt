package com.android.example.guessmoviebymusic.movies.data.repository

import com.android.example.guessmoviebymusic.`typealias`.MovieList
import com.android.example.guessmoviebymusic.di.MovieDao
import com.android.example.guessmoviebymusic.levels.data.db.LevelDb
import com.android.example.guessmoviebymusic.movies.data.db.MovieDb
import com.android.example.guessmoviebymusic.movies.data.remote.MoviesApi
import com.android.example.guessmoviebymusic.movies.domain.usecase.GetMoviesByLevelUseCase
import com.android.example.guessmoviebymusic.movies.domain.repository.MoviesRepository

class MoviesRepositoryImpl(
        private val api: MoviesApi,
        private val dao: MovieDao
): MoviesRepository {

    override suspend fun getAllByLevel(params: GetMoviesByLevelUseCase.Params): MovieList {
        val moviesRemote = api.getMoviesByLevel().data

        val moviesDb = moviesRemote.map { MovieDb(it.id) }
        dao.insert(moviesDb)

        moviesRemote.map { it.isGuessed = dao.isGuessedById(it.id) }

        return moviesRemote
    }
}