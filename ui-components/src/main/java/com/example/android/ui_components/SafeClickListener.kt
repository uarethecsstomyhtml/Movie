package com.example.android.ui_components

import android.media.SoundPool
import android.os.SystemClock
import android.view.View
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Prevent double click
 */
class SafeClickListener constructor(
    private val sound: Int,
    private var defaultInterval: Int = 1000,
    private val onSafeCLick: (View) -> Unit
) : View.OnClickListener, KoinComponent {

    private val soundPool: SoundPool by inject()

    private var lastTimeClicked: Long = 0

    override fun onClick(v: View) {
        soundPool.play(sound)
        if (SystemClock.elapsedRealtime() - lastTimeClicked < defaultInterval) {
            return
        }
        lastTimeClicked = SystemClock.elapsedRealtime()
        onSafeCLick(v)
    }
}