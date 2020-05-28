package com.arman.guessmoviebymusic.movies.data.repository

import com.arman.guessmoviebymusic.base.presentation.MovieState
import com.arman.guessmoviebymusic.movies.data.db.MovieDb
import com.arman.guessmoviebymusic.movies.domain.usecase.GetMoviesByLevelUseCase
import com.arman.guessmoviebymusic.movies.entity.MovieDTO
import com.arman.guessmoviebymusic.movies.presentation.FakeDataSource
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Before
import org.junit.Test
import timber.log.Timber

class DefaultMoviesRepositoryTest {

    private val movie1 = MovieDTO(1, "1", "1", MovieState.OPEN)
    private val movie2 = MovieDTO(2, "2", "2", MovieState.OPEN)
    private val movie3 = MovieDb(3)
    private val movie4 = MovieDb(4)
    private val remoteMovies = listOf(movie1, movie2)
    private val localMovies = listOf(movie3)
    private val newMovies = listOf(movie4)

    private lateinit var moviesRemoteDataSource: FakeDataSource
    private lateinit var moviesLocalDataSource: FakeDataSource

    private lateinit var moviesRepository: DefaultMoviesRepository

    @Before
    fun createRepository() {
        moviesRemoteDataSource = FakeDataSource(remoteMovies = remoteMovies.toMutableList())
        moviesLocalDataSource = FakeDataSource(localMovies = localMovies.toMutableList())
        moviesRepository = DefaultMoviesRepository(moviesRemoteDataSource, moviesLocalDataSource)
    }

    @Test
    fun getMovies_requestAllMoviesByLevelIdFromRemoteDataSource() = runBlockingTest {
        val params = GetMoviesByLevelUseCase.Params(levelId = 1)
        val movies = moviesRepository.getAllByLevel(params)
        assertThat(movies, IsEqual(remoteMovies))
    }

    @Test
    fun saveMovie_req() = runBlockingTest {
        val expected = localMovies + newMovies

        moviesRepository.insert(newMovies)

        val actual = moviesRepository.getAll()

        assertThat(actual, IsEqual(expected))
    }
}