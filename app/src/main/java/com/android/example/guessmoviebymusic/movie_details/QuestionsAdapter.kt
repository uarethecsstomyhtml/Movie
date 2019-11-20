package com.android.example.guessmoviebymusic.movie_details

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.example.guessmoviebymusic.R
import com.android.example.guessmoviebymusic.`typealias`.questionUiClick
import com.android.example.guessmoviebymusic.extension.inflate
import com.android.example.guessmoviebymusic.movie_details.QuestionsAdapter.QuestionViewHolder
import kotlinx.android.synthetic.main.item_movie_question.view.*

class QuestionsAdapter(private val clickListener: questionUiClick) :
    ListAdapter<QuestionUi, QuestionViewHolder>(QuestionUi.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        return QuestionViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.bind(item = getItem(position), clickListener = clickListener)
    }

    class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: QuestionUi, clickListener: questionUiClick) {
            itemView.questionLetter.text = item.letter
        }

        companion object {
            fun from(parent: ViewGroup) = QuestionViewHolder(parent.inflate(R.layout.item_movie_question))
        }
    }
}
