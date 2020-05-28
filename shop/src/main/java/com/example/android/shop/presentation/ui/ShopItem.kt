package com.example.android.shop.presentation.ui

import com.example.android.shop.R.layout.item_shop
import com.example.android.ui_components.setSafeOnClickListener
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_shop.view.*


class ShopItem(
    private val shopUi: ShopUi,
    private val sound: Int,
    private val shopUiClick: ShopUiClick
) : Item() {

    override fun getLayout() = item_shop

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder.itemView) {
            shopName.setText(shopUi.type.title)
            shopIcon.setImageResource(shopUi.type.icon)
            shopDescription.setText(shopUi.subTitle)
            shopDescription.visibility = shopUi.isShowSubtitle
            shopPrice.setText(shopUi.type.price)
            viewLine.visibility = shopUi.isShowLine
            setSafeOnClickListener(sound) { shopUiClick(shopUi) }
        }
    }
}
