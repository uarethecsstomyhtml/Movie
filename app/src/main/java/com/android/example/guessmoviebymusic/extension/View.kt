package com.android.example.guessmoviebymusic.extension

import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.View.INVISIBLE
import android.view.View.GONE
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.android.example.guessmoviebymusic.custom.SafeClickListener

fun View.visible() {
    visibility = VISIBLE
}

fun View.invisible() {
    visibility = INVISIBLE
}

fun View.gone() {
    visibility = GONE
}

// Prevent double click
fun View.setSafeOnClickListener(onSafeClick: (View) -> Unit) {
    val safeClickListener = SafeClickListener {
        onSafeClick(it)
    }
    setOnClickListener(safeClickListener)
}

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)









