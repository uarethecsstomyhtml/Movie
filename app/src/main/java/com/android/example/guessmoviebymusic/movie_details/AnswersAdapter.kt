package com.android.example.guessmoviebymusic.movie_details

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.example.guessmoviebymusic.R
import com.android.example.guessmoviebymusic.`typealias`.answerUiClick
import com.android.example.guessmoviebymusic.extension.inflate
import com.android.example.guessmoviebymusic.movie_details.AnswersAdapter.AnswerViewHolder
import kotlinx.android.synthetic.main.item_movie_answer.view.*

class AnswersAdapter(private val clickListener: answerUiClick) : ListAdapter<AnswerUi, AnswerViewHolder>(AnswerUi.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerViewHolder {
        return AnswerViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: AnswerViewHolder, position: Int) {
        holder.bind(item = getItem(position), clickListener = clickListener)
    }

    class AnswerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: AnswerUi, clickListener: answerUiClick) {
            itemView.answerLetter.text = item.letter
            itemView.setOnClickListener { clickListener(item) }
        }

        companion object {
            fun from(parent: ViewGroup) = AnswerViewHolder(parent.inflate(R.layout.item_movie_answer))
        }
    }
}
