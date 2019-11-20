package com.android.example.guessmoviebymusic.di

import com.android.example.guessmoviebymusic.levels.domain.usecase.GetLevelsUseCase
import com.android.example.guessmoviebymusic.movies.domain.usecase.GetMoviesByLevelUseCase
import org.koin.dsl.module


val useCaseModule = module {
    factory { GetLevelsUseCase(get()) }
    factory { GetMoviesByLevelUseCase(get()) }
}

