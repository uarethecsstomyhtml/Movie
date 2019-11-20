package com.arman.guessmoviebymusic.extension

import android.graphics.Color


fun String.getColorByString(): Int {
    return Color.parseColor(this)
}