package com.example.android.movies.entity


data class LevelDto(
    val id: Long,
    val name: String,
    val imgRes: Int,
    val bgColor: String,
    var passPercentage: Long
) {
    val isGuessed = passPercentage == 100L
}