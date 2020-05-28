package com.example.android.movies.presentation.ui.movie_details.questions

import com.example.android.movies.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_question.view.*
import timber.log.Timber


class QuestionItem(
    private val questionUi: QuestionUi,
    private val questionClick: (QuestionUi) -> Unit
) : Item() {

    override fun getLayout() = R.layout.item_question

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder.itemView) {
            Timber.i("bind, questionUi = $questionUi")
            questionLetter.text = questionUi.answer?.letter
            setOnClickListener { questionClick(questionUi) }
        }
    }
}
