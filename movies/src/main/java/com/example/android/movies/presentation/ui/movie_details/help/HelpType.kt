package com.example.android.movies.presentation.ui.movie_details.help

import com.example.android.movies.R

enum class HelpType(val title: Int, val icon: Int, val color: Int) {
    ADDITIONAL_HELP(R.string.help_additional_title, R.drawable.ic_hint, R.color.colorAccent),
    ASK_FRIENDS(R.string.help_ask_friends_title, R.drawable.ic_ask_friends, R.color.tealLight),
    SHOP(R.string.help_shop_title, R.drawable.ic_shop, R.color.amberLight),
    FREE_100COINS(
        R.string.help_free_100coins_title,
        R.drawable.ic_watch_video_ads,
        R.color.redLight
    )
}