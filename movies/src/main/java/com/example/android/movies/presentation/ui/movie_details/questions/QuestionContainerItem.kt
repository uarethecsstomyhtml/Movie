package com.example.android.movies.presentation.ui.movie_details.questions

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.movies.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_question_container.view.*
import timber.log.Timber


class QuestionContainerItem(
    private val questionContainerUi: QuestionContainerUi,
    private val questionClick: (QuestionUi) -> Unit
) : Item() {

    private lateinit var adapter: GroupAdapter<GroupieViewHolder>

    override fun getLayout() = R.layout.item_question_container

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        Timber.i("bind")
        adapter = GroupAdapter()
        with(viewHolder.itemView) {
            questionsRv.adapter = adapter
            questionsRv.layoutManager = getLayoutManager(context)
            questionsRv.itemAnimator = null
            for (question in questionContainerUi.questions) adapter.add(
                QuestionItem(
                    question,
                    questionClick
                )
            )
        }
    }

    private fun getLayoutManager(context: Context): RecyclerView.LayoutManager {
        return object : LinearLayoutManager(context, RecyclerView.HORIZONTAL, false) {
            override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
                lp?.width = (width / 12).toInt()
                return true
            }
        }
    }

    fun updateQuestionItem(questionUi: QuestionUi) {
        Timber.i("updateQuestionItem, questionUi = $questionUi")
        adapter.getItem(questionUi.positionUpdate).notifyChanged(questionUi.answer?.letter)
    }
}
