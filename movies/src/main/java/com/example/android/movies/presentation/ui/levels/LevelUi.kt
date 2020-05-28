package com.example.android.movies.presentation.ui.levels

import android.graphics.Color
import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize


@Parcelize
data class LevelUi(
    val id: Long,
    val name: String,
    @DrawableRes
    val imgRes: Int,
    val bgColor: String
) : Parcelable {

    @IgnoredOnParcel
    val colorHex = Color.parseColor(bgColor)

}

