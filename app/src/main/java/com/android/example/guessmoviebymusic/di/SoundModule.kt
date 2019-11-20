package com.android.example.guessmoviebymusic.di

import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import com.android.example.guessmoviebymusic.levels.domain.repository.LevelsRepository
import com.android.example.guessmoviebymusic.levels.data.repository.LevelsRepositoryImpl
import com.android.example.guessmoviebymusic.movies.domain.repository.MoviesRepository
import com.android.example.guessmoviebymusic.movies.data.repository.MoviesRepositoryImpl
import org.koin.dsl.module


private fun soundPool(): SoundPool {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        val attrs = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        val sp = SoundPool.Builder()
            .setMaxStreams(10)
            .setAudioAttributes(attrs)
            .build()

        sp
    } else {
        @Suppress("DEPRECATION")
        val sp = SoundPool(10, AudioManager.STREAM_MUSIC, 1)
        sp
    }
}

