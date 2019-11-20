package com.android.example.guessmoviebymusic

import com.android.example.guessmoviebymusic.di.*
import com.android.example.guessmoviebymusic.levels.presentation.LevelsViewModel
import com.android.example.guessmoviebymusic.movie_details.MovieDetailsViewModel
import com.android.example.guessmoviebymusic.movies.presentation.MoviesViewModel
import junit.framework.Assert.assertNotNull
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.koinApplication
import org.koin.test.AutoCloseKoinTest
import org.koin.test.check.checkModules
import org.koin.test.get
import org.koin.test.inject
import org.koin.test.mock.declareMock
import org.mockito.BDDMockito.given

class CheckModulesTest : AutoCloseKoinTest() {

    val viewModel: LevelsViewModel by inject()
    val moviesViewModel: LevelsViewModel by inject()
    val movieDetailsViewModel: LevelsViewModel by inject()


    private val modules = listOf(
        viewModelModule
    )

    @Test
    fun viewModelModule() {
        startKoin { modules(modules) }
        declareMock<LevelsViewModel> {
            given(loadData()).willCallRealMethod()
        }
        declareMock<MoviesViewModel> {
            given(loadData(1)).willCallRealMethod()
        }
        declareMock<MovieDetailsViewModel> {
            given(test()).willCallRealMethod()
        }
//        val levelsViewModel = get<LevelsViewModel>()
//        assertNotNull(levelsViewModel)
    }


    @Test
    fun checkModules() {
        koinApplication {
            printLogger(Level.DEBUG)
            modules(modules)
        }.checkModules()
    }

}