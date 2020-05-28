package com.arman.guessmoviebymusic.hints

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.arman.guessmoviebymusic.getOrAwaitValue
import com.arman.guessmoviebymusic.levels.domain.usecase.GetAmountCoinsUseCase
import com.arman.guessmoviebymusic.levels.domain.usecase.UpdateAmountCoinsUseCase
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock


@RunWith(AndroidJUnit4::class)
class HintsViewModelTest {

    private lateinit var hintsViewModel: HintsViewModel

    @Before
    fun setupViewModel() {
        val amountCoins = mock(GetAmountCoinsUseCase::class.java)
        val updateAmountCoins = mock(UpdateAmountCoinsUseCase::class.java)
        hintsViewModel = HintsViewModel(amountCoins, updateAmountCoins)
    }

    @Test
    fun loadHints_setHintList() {
        hintsViewModel.loadHints()

        val expected = generateHintsUi()

        val actual = hintsViewModel.hints.getOrAwaitValue()

        assertThat(actual, IsEqual(expected))
    }
}