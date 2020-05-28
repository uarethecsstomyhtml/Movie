package com.arman.guessmoviebymusic.levels.presentation

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.arman.guessmoviebymusic.R
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


@RunWith(AndroidJUnit4::class)
@MediumTest
class LevelsFragmentTest {

    @Test
    fun testNavigationToMoviesScreen() {
        // Create a mock NavController
        val navController = mock(NavController::class.java)

        // Create Level and Action
        val level = LevelUi(1, "Новичок", R.drawable.level1, "#64B5F6")
        val action = LevelsFragmentDirections.actionLevelToMovies(level)

        // Create a graphical FragmentScenario for the TitleScreen
        val levelsScenario =
            launchFragmentInContainer<LevelsFragment>(Bundle(), R.style.AppTheme)

//         Set the NavController property on the fragment
        levelsScenario.onFragment { fragment ->
            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        onView(withId(R.id.rvLevels)).perform(
            actionOnItem<RecyclerView.ViewHolder>(
                hasDescendant(withId(1)), click()
            )
        )
        verify(navController).navigate(action)
    }
}