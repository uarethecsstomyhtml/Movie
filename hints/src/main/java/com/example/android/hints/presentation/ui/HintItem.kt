package com.example.android.hints.presentation.ui

import com.example.android.hints.R
import com.example.android.ui_components.setSafeOnClickListener
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_hint.view.*


class HintItem(
    private val hintUi: HintUi,
    private val sound: Int,
    private val hintUiClick: HintUiClick
) : Item() {

    override fun getLayout() = R.layout.item_hint

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder.itemView) {
            hintName.setText(hintUi.type.titleRes)
            hintIcon.setImageResource(hintUi.type.iconRes)
            hintPrice.visibility = hintUi.isShowPrice
            hintPrice.text = hintUi.price
            setSafeOnClickListener(sound) { hintUiClick(hintUi) }
        }
    }
}
