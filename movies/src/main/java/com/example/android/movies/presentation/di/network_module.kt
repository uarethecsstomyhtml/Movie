package com.example.android.movies.presentation.di

import com.example.android.movies.data.remote.MoviesApi
import com.example.android.movies.data.remote.levels.LevelsApi
import org.koin.dsl.module
import retrofit2.Retrofit

private fun moviesApi(retrofit: Retrofit) = retrofit.create(MoviesApi::class.java)
private fun levelsApi(retrofit: Retrofit) = retrofit.create(LevelsApi::class.java)

val moviesNetworkModule = module {
    single { moviesApi(retrofit = get()) }
    single { levelsApi(retrofit = get()) }
}