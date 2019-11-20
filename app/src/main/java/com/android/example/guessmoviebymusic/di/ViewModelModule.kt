package com.android.example.guessmoviebymusic.di

import com.android.example.guessmoviebymusic.AdsGdprViewModel
import com.android.example.guessmoviebymusic.HintsViewModel
import com.android.example.guessmoviebymusic.ShopViewModel
import com.android.example.guessmoviebymusic.levels.presentation.LevelsViewModel
import com.android.example.guessmoviebymusic.movie_details.MovieDetailsViewModel
import com.android.example.guessmoviebymusic.movies.presentation.MoviesViewModel
import com.android.example.guessmoviebymusic.victory.AdsGdprResultViewModel
import com.android.example.guessmoviebymusic.victory.VictoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LevelsViewModel( getLevelsUseCase = get()) }
    viewModel { MoviesViewModel( moviesByLevelUseCase = get()) }
    viewModel { MovieDetailsViewModel() }
    viewModel { VictoryViewModel() }
    viewModel { HintsViewModel() }
    viewModel { ShopViewModel() }
    viewModel { AdsGdprViewModel() }
    viewModel { AdsGdprResultViewModel() }

}