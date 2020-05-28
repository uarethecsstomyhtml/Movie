package com.example.android.movies.presentation.di

import com.example.android.movies.data.local.MoviesLocalDataSource
import com.example.android.movies.data.remote.MoviesRemoteDataSource
import com.example.android.movies.domain.datasource.MoviesDataSource
import org.koin.dsl.module

val moviesDataSourceModule = module {
    factory<MoviesDataSource> { MoviesRemoteDataSource(api = get()) }
//    factory { MoviesLocalDataSource(dao = get()) as MoviesDataSource }
    factory { MoviesLocalDataSource(dao = get()) }
}