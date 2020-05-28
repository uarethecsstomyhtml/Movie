package com.example.android.movies.presentation.ui

import android.graphics.Color
import androidx.core.content.ContextCompat
import com.example.android.movies.R
import com.example.android.movies.presentation.MovieUiClick
import com.example.android.ui_components.setSafeOnClickListener
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_movie.view.*


class MovieItem(
    private val movieUi: MovieUi,
    private val bgColor: String,
    private val sound: Int,
    private val movieUiClick: MovieUiClick
) : Item() {

    override fun getLayout() = R.layout.item_movie

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder.itemView) {
            movieName.text = movieUi.nameUi
            movieName.setTextColor(ContextCompat.getColor(context, movieUi.nameColorUi))
            movieImg.setImageResource(movieUi.imgUi)
            movieRoot.setCardBackgroundColor(Color.parseColor(bgColor))


            setSafeOnClickListener(sound) { movieUiClick(movieUi) }
        }
    }
}
