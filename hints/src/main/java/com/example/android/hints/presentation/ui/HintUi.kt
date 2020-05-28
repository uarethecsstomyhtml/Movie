package com.example.android.hints.presentation.ui

import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.annotation.DrawableRes


data class HintUi(
    val type: HintType,
    val price: String = ""
) {
    val isShowPrice = if (price.isNotBlank()) VISIBLE else GONE
}

