package com.arman.guessmoviebymusic.movies.presentation

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.arman.guessmoviebymusic.getOrAwaitValue
import com.arman.guessmoviebymusic.movies.domain.usecase.GetMoviesByLevelUseCase
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.core.Is
import org.hamcrest.core.IsEqual
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MoviesViewModelTest {

    private lateinit var moviesRepository: FakeMoviesRepository
    private lateinit var fakeFailingMoviesRepository: FakeFailingMoviesRepository
    private lateinit var getMoviesByLevelUseCase: GetMoviesByLevelUseCase

    private lateinit var moviesViewModel: MoviesViewModel

    @Before
    fun init() {
        moviesRepository = FakeMoviesRepository()
        fakeFailingMoviesRepository = FakeFailingMoviesRepository()

        getMoviesByLevelUseCase = GetMoviesByLevelUseCase(fakeFailingMoviesRepository)
        moviesViewModel = MoviesViewModel(getMoviesByLevelUseCase)
    }


    @Test
    fun loadMovies_setsSuccess() {
        moviesViewModel.loadMoviesByLevelId(1)
        val actual = moviesViewModel.movies.getOrAwaitValue() as Success

        val expected =
            moviesRepository.levels.map { MovieUi(it.id, it.name, it.state, it.answerLetters) }

        assertThat(actual.data, IsEqual(expected))
    }

    @Test
    fun loadMovies_setsError() {
        moviesViewModel.loadMoviesByLevelId(1)
        val actual = moviesViewModel.movies.getOrAwaitValue() as Error

        assertThat(actual.throwable, Is(notNullValue()))
    }


}