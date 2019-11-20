package com.android.example.guessmoviebymusic

import android.view.View
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.recyclerview.widget.DiffUtil
import com.android.example.guessmoviebymusic.R.drawable.ic_shop_coins_350
import com.android.example.guessmoviebymusic.R.drawable.ic_shop_coins_750
import com.android.example.guessmoviebymusic.R.drawable.ic_shop_coins_2000
import com.android.example.guessmoviebymusic.R.drawable.ic_shop_coins_4500
import com.android.example.guessmoviebymusic.R.drawable.ic_shop_coins_15000
import com.android.example.guessmoviebymusic.R.drawable.ic_shop_block_ads
import com.android.example.guessmoviebymusic.R.drawable.ic_shop_free_100_coins
import com.android.example.guessmoviebymusic.R.string.label_coins_350
import com.android.example.guessmoviebymusic.R.string.label_coins_750
import com.android.example.guessmoviebymusic.R.string.label_coins_2000
import com.android.example.guessmoviebymusic.R.string.label_coins_4500
import com.android.example.guessmoviebymusic.R.string.label_coins_15000
import com.android.example.guessmoviebymusic.R.string.label_block_ads
import com.android.example.guessmoviebymusic.R.string.label_100_coins
import com.android.example.guessmoviebymusic.R.string.description_best_deal
import com.android.example.guessmoviebymusic.R.string.description_free_100_coins


import com.android.example.guessmoviebymusic.ShopType.*


data class ShopUi (
    val id: Long,
    @StringRes val name: Int,
    val type: ShopType,
    val price: String,
    @DrawableRes val imgRes: Int,
    @StringRes val description: Int = R.string.text_empty
    ) {

    val descriptionVisibility = if (description != R.string.text_empty) View.VISIBLE else View.GONE

    val viewLineVisibility = if (type == BLOCK_ADS) View.VISIBLE else View.GONE

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ShopUi>() {
            override fun areItemsTheSame(oldItem: ShopUi, newItem: ShopUi): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: ShopUi, newItem: ShopUi): Boolean =
                oldItem == newItem
        }
    }
}

fun generateShopUi(): MutableList<ShopUi> {
    val list = mutableListOf<ShopUi>()
    list.add(ShopUi(1, label_coins_350, COINS_350, "389,99 ₸", ic_shop_coins_350))
    list.add(ShopUi(2, label_coins_750, COINS_750, "419,99 ₸", ic_shop_coins_750))
    list.add(ShopUi(3, label_coins_2000, COINS_2000, "1 799,99 ₸", ic_shop_coins_2000))
    list.add(ShopUi(4, label_coins_4500, COINS_4500, "1849, 99 ₸", ic_shop_coins_4500))
    list.add(ShopUi(5, label_coins_15000, COINS_15000, "3 749,99 ₸", ic_shop_coins_15000, description_best_deal))
    list.add(ShopUi(6, label_block_ads, BLOCK_ADS, "699,99 ₸", ic_shop_block_ads))
    list.add(ShopUi(7, label_100_coins, FREE_100_COINS, "Бесплатно!", ic_shop_free_100_coins, description_free_100_coins))
    return list
}
