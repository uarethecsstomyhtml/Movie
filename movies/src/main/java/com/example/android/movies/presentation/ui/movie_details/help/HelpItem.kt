package com.example.android.movies.presentation.ui.movie_details.help

import android.content.res.ColorStateList
import androidx.core.content.ContextCompat
import com.example.android.movies.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_help.view.*
import kotlinx.android.synthetic.main.item_movie.view.*


class HelpItem(private val helpType: HelpType) : Item() {

    override fun getLayout() = R.layout.item_help

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder.itemView) {
            helpTitle.setText(helpType.title)
            helpImg.setImageResource(helpType.icon)
            helpImg.setBackgroundColor(helpType.color)
            helpImg.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(context, helpType.color))
        }
    }
}
