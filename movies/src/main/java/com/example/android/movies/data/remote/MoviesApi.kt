package com.example.android.movies.data.remote

import com.example.android.movies.presentation.MovieDtoListResponse
import retrofit2.http.*

interface MoviesApi {

    @GET("movies")
    suspend fun getMoviesByLevel(): MovieDtoListResponse

    @Streaming
    @GET("download/{id}")
    suspend fun downloadSoundtrackByMovie()
}