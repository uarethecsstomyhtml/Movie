package com.android.example.guessmoviebymusic

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.example.guessmoviebymusic.R
import com.android.example.guessmoviebymusic.`typealias`.hintUiClick
import com.android.example.guessmoviebymusic.`typealias`.levelUiClick
import com.android.example.guessmoviebymusic.extension.inflate
import com.android.example.guessmoviebymusic.extension.load
import com.android.example.guessmoviebymusic.extension.setSafeOnClickListener
import kotlinx.android.synthetic.main.item_hint.view.*
import kotlinx.android.synthetic.main.item_level.view.*
import timber.log.Timber

class HintsAdapter(private val clickListener: hintUiClick)
    : ListAdapter<HintUi, HintsAdapter.HintsViewHolder>(HintUi.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HintsViewHolder {
        Timber.d("onCreateViewHolder")
        return HintsViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: HintsViewHolder, position: Int) {
        Timber.d("onBindViewHolder, position: $position")
        holder.bind(item = getItem(position), clickListener = clickListener)
    }

    class HintsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: HintUi, clickListener: hintUiClick) {
            Timber.d("onBindViewHolder, item: $item")
            with(itemView) {
                hintName.text = item.name
                hintIcon.setImageResource(item.imgRes)
                with(hintPrice) {
                    visibility = item.priceVisibility
                    text = item.price
                }
                setSafeOnClickListener { clickListener(item) }
            }

        }

        companion object {
            fun from(parent: ViewGroup) = HintsViewHolder(parent.inflate(R.layout.item_hint))
        }
    }
}
