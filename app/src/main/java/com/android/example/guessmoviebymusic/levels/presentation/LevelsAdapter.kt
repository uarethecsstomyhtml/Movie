package com.android.example.guessmoviebymusic.levels.presentation

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.example.guessmoviebymusic.R
import com.android.example.guessmoviebymusic.`typealias`.levelUiClick
import com.android.example.guessmoviebymusic.extension.inflate
import com.android.example.guessmoviebymusic.extension.load
import com.android.example.guessmoviebymusic.extension.setSafeOnClickListener
import kotlinx.android.synthetic.main.item_level.view.*
import timber.log.Timber

class LevelsAdapter(private val clickListener: levelUiClick)
    : ListAdapter<LevelUi, LevelsAdapter.LevelsViewHolder>(LevelUi.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelsViewHolder {
        Timber.d("onCreateViewHolder")
        return LevelsViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: LevelsViewHolder, position: Int) {
        Timber.d("onBindViewHolder, position: $position")
        holder.bind(item = getItem(position), clickListener = clickListener)
    }

    class LevelsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: LevelUi, clickListener: levelUiClick) {
            Timber.d("onBindViewHolder, item: $item")
            with(itemView) {
                levelName.text = item.name
                levelImg.load(item.imgUrl)
                setSafeOnClickListener { clickListener(item) }
            }

        }

        companion object {
            fun from(parent: ViewGroup) = LevelsViewHolder(parent.inflate(R.layout.item_level))
        }
    }
}
