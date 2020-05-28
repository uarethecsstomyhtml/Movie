package com.example.android.shop.presentation.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.android.shop.R.drawable.*
import com.example.android.shop.R.string.*


enum class ShopType(
    @StringRes val title: Int,
    @StringRes val price: Int,
    @DrawableRes val icon: Int
) {
    COINS_350(title_coins350, price_coins350, ic_350coins),
    COINS_750(title_coins750, price_coins750, ic_750coins),
    COINS_2000(title_coins2000, price_coins2000, ic_2000coins),
    COINS_4500(title_coins4500, price_coins4500, ic_4500coins),
    COINS_15000(title_coins15000, price_coins15000, ic_15000coins),
    BLOCK_ADS(title_block_ads, price_block_ads, ic_block_ads),
    FREE_100_COINS(title_free_100coins, price_free_100coins, ic_free_100coins)
}