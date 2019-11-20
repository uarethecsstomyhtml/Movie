package com.android.example.guessmoviebymusic.movies.data.remote

import com.android.example.guessmoviebymusic.`typealias`.MovieListNetworkResponse
import com.android.example.guessmoviebymusic.movies.domain.usecase.GetMoviesByLevelUseCase
import retrofit2.http.*

interface MoviesApi {

    @GET("movies")
    @Headers("Content-Type: application/json")
    suspend fun getMoviesByLevel(): MovieListNetworkResponse

    @Streaming
    @GET("downloadMovies")
    @Headers("Content-Type: application/json")
    suspend fun downloadSoundtrackByMovie()
}