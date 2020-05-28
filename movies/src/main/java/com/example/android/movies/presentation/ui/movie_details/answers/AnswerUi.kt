package com.example.android.movies.presentation.ui.movie_details.answers

import android.view.View.GONE
import android.view.View.VISIBLE


data class AnswerUi(
    val id: Long,
    val letter: String,
    val bgColor: String,
    var questionId: Long = 0,
    var position: Int = 0
) {
    var isShowLetter = if (questionId == 0L) VISIBLE else GONE
}
