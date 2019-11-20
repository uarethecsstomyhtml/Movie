package com.arman.guessmoviebymusic.extension

import android.media.SoundPool

fun SoundPool.play(sound: Int) {
    play(sound, 1f, 1f, 1, 0, 1f)
}
