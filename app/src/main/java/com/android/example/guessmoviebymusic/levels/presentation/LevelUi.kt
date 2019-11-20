package com.android.example.guessmoviebymusic.levels.presentation

import androidx.recyclerview.widget.DiffUtil


data class LevelUi(
    val id: Long,
    val name: String,
    val imgUrl: String?,
    val bgColor: String
) {
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<LevelUi>() {
            override fun areItemsTheSame(oldItem: LevelUi, newItem: LevelUi): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: LevelUi, newItem: LevelUi): Boolean =
                oldItem == newItem
        }
    }
}
