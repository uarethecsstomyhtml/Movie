package com.example.android.movies.presentation.di

import com.example.android.movies.domain.usecase.GetLevelsUseCase
import com.example.android.movies.domain.usecase.GetMoviesByLevelUseCase
import org.koin.dsl.module

val moviesUseCaseModule = module {
    factory { GetMoviesByLevelUseCase(moviesRepository = get()) }
    factory { GetLevelsUseCase(levelsRepository = get()) }

}