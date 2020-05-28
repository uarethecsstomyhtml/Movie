package com.example.android.movies.presentation.ui.levels

import com.example.android.movies.R
import com.example.android.ui_components.setSafeOnClickListener
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_level.view.*


class LevelItem(
    private val levelUi: LevelUi,
    private val sound: Int,
    private val levelUiClick: LevelUiClick
) : Item() {

    override fun getLayout() = R.layout.item_level

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder.itemView) {
            levelName.text = levelUi.name
            levelImg.setImageResource(levelUi.imgRes) // Redo loadRes - ext.function
            setSafeOnClickListener(sound) { levelUiClick(levelUi) }
        }
    }
}
