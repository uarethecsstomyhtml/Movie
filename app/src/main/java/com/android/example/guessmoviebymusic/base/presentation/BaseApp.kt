package com.android.example.guessmoviebymusic.base.presentation

import android.app.Application
import androidx.multidex.MultiDex
import com.android.example.guessmoviebymusic.BuildConfig
import com.android.example.guessmoviebymusic.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

/**
 * Include configs:
 * Timber(Logging)
 * Koin(Dependency injection)
 * Crashlytics
 * Multidex
 */
class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initLogging()
        initKoin()
        initMultidex()
    }

    private fun initLogging() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

    private fun initKoin() {
        startKoin {
            printLogger(level = Level.DEBUG)

            androidContext(this@BaseApp)

            modules(listOf(networkModule, apiModule, roomModule, viewModelModule, repositoryModule, useCaseModule))
        }
    }

    private fun initMultidex() {
        MultiDex.install(this)
    }
}