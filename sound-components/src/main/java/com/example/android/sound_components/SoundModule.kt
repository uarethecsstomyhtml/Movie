package com.example.android.sound_components

import android.app.Application
import android.media.AudioAttributes
import android.media.AudioManager.STREAM_MUSIC
import android.media.SoundPool
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.LOLLIPOP
import androidx.annotation.RequiresApi
import com.example.android.sound_components.R.raw.*
import org.koin.core.qualifier.named
import org.koin.dsl.module
import timber.log.Timber

const val SOUND_ALERT_NAME = "soundAlert"
const val SOUND_LEVEL_NAME = "soundLevel"
const val SOUND_BACK_TO_LEVEL_NAME = "soundBackToLevel"
const val SOUND_MOVIE_NAME = "soundMovie"
const val SOUND_BACK_TO_MOVIE = "soundBackToMovie"
const val SOUND_UI_TAP_NAME = "soundUiTap"
const val SOUND_CANCEL = "soundCancel"

private const val MAX_STREAMS = 10
private const val PRIORITY = 1
private const val QUALITY = 1

private fun soundPool(): SoundPool {
    return if (SDK_INT >= LOLLIPOP) soundPoolV21() else soundPoolLower21()
}

@RequiresApi(LOLLIPOP)
private fun soundPoolV21(): SoundPool {
    Timber.i("soundPoolV21")
    val attrs = AudioAttributes.Builder()
        .setUsage(AudioAttributes.USAGE_GAME)
        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
        .build()
    return SoundPool.Builder()
        .setMaxStreams(10)
        .setAudioAttributes(attrs)
        .build()
}

@Suppress("DEPRECATION")
private fun soundPoolLower21() = SoundPool(MAX_STREAMS, STREAM_MUSIC, QUALITY)


val soundModule = module {
    single { soundPool() }
    single(named(SOUND_ALERT_NAME)) { soundAlert(app = get(), soundPool = get()) }
    single(named(SOUND_LEVEL_NAME)) { soundLevel(app = get(), soundPool = get()) }
    single(named(SOUND_BACK_TO_LEVEL_NAME)) { soundBackToLevel(app = get(), soundPool = get()) }
    single(named(SOUND_MOVIE_NAME)) { soundMovie(app = get(), soundPool = get()) }
    single(named(SOUND_BACK_TO_MOVIE)) { soundBackToMovie(app = get(), soundPool = get()) }
    single(named(SOUND_UI_TAP_NAME)) { soundUiTap(app = get(), soundPool = get()) }
    single(named(SOUND_CANCEL)) { soundCancel(app = get(), soundPool = get()) }
}

private fun soundAlert(app: Application, soundPool: SoundPool): Int {
    return soundPool.load(app.applicationContext, alert_high_intensity, PRIORITY)
}

private fun soundLevel(app: Application, soundPool: SoundPool): Int {
    return soundPool.load(app.applicationContext, navigation_forward_selection, PRIORITY)
}

private fun soundBackToLevel(app: Application, soundPool: SoundPool): Int {
    return soundPool.load(app.applicationContext, navigation_backward_selection, PRIORITY)
}

private fun soundMovie(app: Application, soundPool: SoundPool): Int {
    return soundPool.load(app.applicationContext, navigation_forward_selection_minimal, PRIORITY)
}

private fun soundBackToMovie(app: Application, soundPool: SoundPool): Int {
    return soundPool.load(app.applicationContext, navigation_backward_selection_minimal, PRIORITY)
}

private fun soundUiTap(app: Application, soundPool: SoundPool): Int {
    return soundPool.load(app.applicationContext, ui_tap, PRIORITY)
}

private fun soundCancel(app: Application, soundPool: SoundPool): Int {
    return soundPool.load(app.applicationContext, navigation_cancel, PRIORITY)
}




