package com.example.android.movies.presentation.di

import com.example.android.movies.presentation.ui.MoviesViewModel
import com.example.android.movies.presentation.ui.levels.LevelsViewModel
import com.example.android.movies.presentation.ui.movie_details.MovieDetailsViewModel
import com.example.android.movies.presentation.ui.victory.VictoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moviesViewModelModule = module {
    viewModel { MoviesViewModel(getMoviesByLevelUseCase = get()) }
    viewModel { MovieDetailsViewModel() }
    viewModel { VictoryViewModel() }
    viewModel { LevelsViewModel(getLevelsUseCase = get()) }
}