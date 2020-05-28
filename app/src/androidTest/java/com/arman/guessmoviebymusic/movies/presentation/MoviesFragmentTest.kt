package com.arman.guessmoviebymusic.movies.presentation

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class MoviesFragmentTest {

    @Test
    fun testNavigationToMoviesScreen() {
        // Create a mock NavController
        // Create Level and Action
        val moviesScenario = launchFragmentInContainer<MoviesFragment>()

    }
}