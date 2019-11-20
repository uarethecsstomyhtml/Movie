package com.android.example.guessmoviebymusic.extension

import com.android.example.guessmoviebymusic.R


fun Boolean?.getDrawable(): Int? {
    return when {
        this == null -> return null
        this -> R.drawable.ic_hint_rate_app
        else -> R.drawable.ic_hint_rate_app
    }
}