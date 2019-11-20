package com.android.example.guessmoviebymusic

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.example.guessmoviebymusic.`typealias`.shopUiClick
import com.android.example.guessmoviebymusic.extension.inflate
import kotlinx.android.synthetic.main.item_shop.view.*
import timber.log.Timber

class ShopAdapter(private val clickListener: shopUiClick)
    : ListAdapter<ShopUi, ShopAdapter.ShopViewHolder>(ShopUi.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        Timber.d("onCreateViewHolder")
        return ShopViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        Timber.d("onBindViewHolder, position: $position")
        holder.bind(item = getItem(position), clickListener = clickListener)
    }

    class ShopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: ShopUi, clickListener: shopUiClick) {
            Timber.d("onBindViewHolder, item: $item")
            itemView.apply {
                shopName.setText(item.name)
                shopIcon.setImageResource(item.imgRes)
                shopPrice.text = item.price
                shopDescription.apply {
                    setText(item.description)
                    visibility = item.descriptionVisibility
                }
                viewLine.visibility = item.viewLineVisibility
                setOnClickListener { clickListener(item) }
            }

        }

        companion object {
            fun from(parent: ViewGroup) = ShopViewHolder(parent.inflate(R.layout.item_shop))
        }
    }
}
