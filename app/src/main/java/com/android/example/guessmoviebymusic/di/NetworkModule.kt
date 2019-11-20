package com.android.example.guessmoviebymusic.di


import android.app.Application
import com.android.example.guessmoviebymusic.BuildConfig.DEBUG
import com.android.example.guessmoviebymusic.levels.data.remote.LevelsApi
import com.android.example.guessmoviebymusic.movies.data.remote.MoviesApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "http://192.168.8.188:9999/"

val networkModule = module {
    single { httpCache(app = get()) }
    single { gson() }
    single { okHttpClient(cache = get()) }
    single { retrofitClient(gson = get(), okHttpClient = get()) }
}

val apiModule = module {
    single { levelsApi(retrofit = get()) }
    single { moviesApi(retrofit = get()) }
}

private fun gson() : Gson {
    return GsonBuilder().create()
}

private fun httpCache(app : Application) : Cache {
    val cacheSize: Long = 10 * 1024 * 1024
    return Cache(app.cacheDir, cacheSize)
}

private fun okHttpClient(cache : Cache) : OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = if (DEBUG) BODY else NONE

    return with(OkHttpClient.Builder()) {
         cache(cache)
         addInterceptor(httpLoggingInterceptor)
         build()
    }
}

private fun retrofitClient(gson : Gson, okHttpClient: OkHttpClient): Retrofit  {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()
}

private fun levelsApi(retrofit: Retrofit) = retrofit.create(LevelsApi::class.java)
private fun moviesApi(retrofit: Retrofit) = retrofit.create(MoviesApi::class.java)



