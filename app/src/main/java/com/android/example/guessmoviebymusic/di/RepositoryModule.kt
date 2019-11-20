package com.android.example.guessmoviebymusic.di

import com.android.example.guessmoviebymusic.levels.domain.repository.LevelsRepository
import com.android.example.guessmoviebymusic.levels.data.repository.LevelsRepositoryImpl
import com.android.example.guessmoviebymusic.movies.domain.repository.MoviesRepository
import com.android.example.guessmoviebymusic.movies.data.repository.MoviesRepositoryImpl
import org.koin.dsl.module


val repositoryModule = module {
    factory { LevelsRepositoryImpl(api = get(), dao = get()) as LevelsRepository }
    factory { MoviesRepositoryImpl(api = get(), dao = get()) as MoviesRepository }

}

