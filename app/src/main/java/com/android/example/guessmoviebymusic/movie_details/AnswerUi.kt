package com.android.example.guessmoviebymusic.movie_details

import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class AnswerUi(
    @PrimaryKey
    val id: Long,
    val letter: String,
    val bgColor: String
) {
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<AnswerUi>() {
            override fun areItemsTheSame(oldItem: AnswerUi, newItem: AnswerUi): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: AnswerUi, newItem: AnswerUi): Boolean =
                oldItem == newItem
        }
    }
}
