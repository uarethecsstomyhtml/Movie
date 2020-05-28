package com.example.android.movies.data.remote.levels

import com.example.android.movies.presentation.ui.levels.LevelDtoListResponse
import retrofit2.http.GET

interface LevelsApi {

    @GET("/levels")
    suspend fun getLevels(): LevelDtoListResponse

}