package com.android.example.guessmoviebymusic.movie_details

import androidx.recyclerview.widget.DiffUtil


data class QuestionUi(
    val id: Long,
    val letter: String,
    val color: String,
    val isUsedTooltip: Boolean = false
) {
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<QuestionUi>() {
            override fun areItemsTheSame(oldItem: QuestionUi, newItem: QuestionUi): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: QuestionUi, newItem: QuestionUi): Boolean =
                oldItem == newItem
        }
    }
}
