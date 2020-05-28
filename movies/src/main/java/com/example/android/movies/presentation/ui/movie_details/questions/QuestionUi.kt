package com.example.android.movies.presentation.ui.movie_details.questions

import com.example.android.movies.presentation.ui.movie_details.answers.AnswerUi


data class QuestionUi(
    val id: Long,
    val color: String,
    val isUsedTooltip: Boolean = false,
    var answer: AnswerUi? = null,
    var rowUpdate: Int = 0,
    var positionUpdate: Int = 0
)
