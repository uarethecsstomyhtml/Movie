package com.android.example.guessmoviebymusic.extension

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


fun ImageView.load(url: String?) {
    url.let {
        Glide.with(this.context).load(it).placeholder(ColorDrawable(Color.WHITE)).into(this)
    }
}

@SuppressWarnings("Not used")
fun ImageView.loadImageRound(url: String) =
    Glide.with(this).load(url).apply(RequestOptions.circleCropTransform()).into(this)