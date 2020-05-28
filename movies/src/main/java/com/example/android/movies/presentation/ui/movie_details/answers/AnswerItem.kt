package com.example.android.movies.presentation.ui.movie_details.answers

import com.example.android.movies.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_answer.view.*


class AnswerItem(
    val answerUi: AnswerUi,
    val answerClick: (AnswerUi, Int) -> Unit
) : Item() {

    override fun getLayout() = R.layout.item_answer

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder.itemView) {
            answerLetter.text = answerUi.letter
            visibility = answerUi.isShowLetter
            setOnClickListener { answerClick(answerUi, position) }
        }
    }
}
