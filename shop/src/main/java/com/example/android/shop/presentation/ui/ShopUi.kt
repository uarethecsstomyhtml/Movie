package com.example.android.shop.presentation.ui

import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.annotation.StringRes
import com.example.android.shop.R.string.*
import com.example.android.shop.presentation.ui.ShopType.*


data class ShopUi(
    val type: ShopType,
    @StringRes val subTitle: Int = text_empty
) {

    val isShowSubtitle = when (type) {
        COINS_15000, FREE_100_COINS -> VISIBLE
        else -> GONE
    }

    val isShowLine = if (type == BLOCK_ADS) VISIBLE else GONE

}

fun generateShopUi() = listOf(
    ShopUi(COINS_350),
    ShopUi(COINS_750),
    ShopUi(COINS_2000),
    ShopUi(COINS_4500),
    ShopUi(COINS_15000, subtitle_best_deal),
    ShopUi(BLOCK_ADS),
    ShopUi(FREE_100_COINS, subtitle_free_100_coins)
)

