package com.android.example.guessmoviebymusic.levels.entity

import com.google.gson.annotations.Expose

data class Level(
    val id: Long,
    val name: String,
    val imgUrl: String?,
    val bgColor: String,
    @Expose var passPercentage: Long
) {
    val isGuessed = passPercentage == 100L
}
