package com.android.example.guessmoviebymusic.movies.presentation

import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.DiffUtil
import com.android.example.guessmoviebymusic.`typealias`.QuestionUiList


data class MovieUi(
    val id: Long,
    val name: String,
    @DrawableRes val imgRes: Int
//    val questionLetters: QuestionUiList,
//    val answerLetters: QuestionUiList

) {
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieUi>() {
            override fun areItemsTheSame(oldItem: MovieUi, newItem: MovieUi): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: MovieUi, newItem: MovieUi): Boolean =
                oldItem == newItem
        }
    }
}
