package com.example.android.movies.presentation.di

import com.example.android.movies.data.repository.DefaultLevelsRepository
import com.example.android.movies.data.repository.DefaultMoviesRepository
import com.example.android.movies.domain.repository.LevelsRepository
import com.example.android.movies.domain.repository.MoviesRepository
import org.koin.dsl.module


val moviesRepositoryModule = module {
    single<MoviesRepository> {
        DefaultMoviesRepository(
            moviesRemoteDataSource = get(),
            moviesLocalDataSource = get()
        )
    }
    single<LevelsRepository> { DefaultLevelsRepository(levelsApi = get(), levelDao = get()) }
}