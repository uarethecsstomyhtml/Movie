package com.android.example.guessmoviebymusic.levels.data.remote

import com.android.example.guessmoviebymusic.`typealias`.LevelListNetworkResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface LevelsApi {

    @GET("/levels")
    @Headers("Content-Type: application/json")
    suspend fun getLevels(): LevelListNetworkResponse

}