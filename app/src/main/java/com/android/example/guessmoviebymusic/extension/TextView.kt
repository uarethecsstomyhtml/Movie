package com.android.example.guessmoviebymusic.extension

import android.animation.ValueAnimator
import android.widget.TextView

fun TextView.coinIncreaseAnimation(initAmount: Int, finalAmount: Int) {
    val animator = ValueAnimator.ofInt(initAmount, finalAmount)
    animator.duration = 2000
    animator.addUpdateListener { animation -> text = animation.animatedValue.toString() }
    animator.start()
}