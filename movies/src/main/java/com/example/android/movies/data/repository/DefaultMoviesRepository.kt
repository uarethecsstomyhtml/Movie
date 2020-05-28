package com.example.android.movies.data.repository

import com.example.android.movies.data.local.MovieDb
import com.example.android.movies.domain.datasource.MoviesDataSource
import com.example.android.movies.domain.repository.MoviesRepository
import com.example.android.movies.domain.usecase.GetMoviesByLevelUseCase
import com.example.android.movies.entity.MovieDto
import com.example.android.movies.presentation.MovieDbList
import com.example.android.movies.presentation.MovieDtoList
import com.example.android.movies.presentation.MovieStatus

class DefaultMoviesRepository(
    private val moviesRemoteDataSource: MoviesDataSource,
    private val moviesLocalDataSource: MoviesDataSource
) : MoviesRepository {

    private val movies = listOf(
        MovieDto(1, "Игра престолов", "sdf", MovieStatus.GUESSED),
        MovieDto(2, "Бригада", "sdf", MovieStatus.GUESSED),
        MovieDto(3, "Тутут", "sdf", MovieStatus.OPEN),
        MovieDto(4, "Ван Хельсинг", "sdf", MovieStatus.OPEN),
        MovieDto(5, "Наруто", "sdf", MovieStatus.OPEN),
        MovieDto(6, "Боруто", "sdf", MovieStatus.CLOSED),
        MovieDto(7, "Ван Хельсинг", "sdf", MovieStatus.CLOSED),
        MovieDto(8, "Наруто", "sdf", MovieStatus.CLOSED),
        MovieDto(9, "Боруто", "sdf", MovieStatus.CLOSED),
        MovieDto(10, "Ван Хельсинг", "sdf", MovieStatus.CLOSED),
        MovieDto(11, "Наруто", "sdf", MovieStatus.CLOSED),
        MovieDto(12, "Боруто", "sdf", MovieStatus.CLOSED),
        MovieDto(13, "Ван Хельсинг", "sdf", MovieStatus.CLOSED),
        MovieDto(14, "Наруто", "sdf", MovieStatus.CLOSED),
        MovieDto(15, "Боруто", "sdf", MovieStatus.CLOSED),
        MovieDto(16, "Ван Хельсинг", "sdf", MovieStatus.CLOSED),
        MovieDto(17, "Наруто", "sdf", MovieStatus.CLOSED),
        MovieDto(18, "Боруто", "sdf", MovieStatus.CLOSED),
        MovieDto(19, "Боруто", "sdf", MovieStatus.CLOSED),
        MovieDto(20, "Боруто", "sdf", MovieStatus.CLOSED),
        MovieDto(21, "Боруто", "sdf", MovieStatus.CLOSED),
        MovieDto(22, "Боруто", "sdf", MovieStatus.CLOSED),
        MovieDto(23, "Боруто", "sdf", MovieStatus.CLOSED),
        MovieDto(24, "Боруто", "sdf", MovieStatus.CLOSED)
    )

    override suspend fun getAllByLevel(params: GetMoviesByLevelUseCase.Params): MovieDtoList {
//        val moviesRemote = moviesRemoteDataSource.getAllByLevel(params)

//        val moviesDb = moviesRemote.map { MovieDb(it.id) }
//        insert(moviesDb)

//        moviesRemote.map { it.state = moviesLocalDataSource.getStatusById(it.id) }

        return movies
//        return moviesRemote
    }

    override suspend fun insert(movies: MovieDbList) {
        moviesLocalDataSource.insertAll(movies)
    }

    override suspend fun getAll(): MovieDbList {
        return moviesLocalDataSource.getAll()
    }


}