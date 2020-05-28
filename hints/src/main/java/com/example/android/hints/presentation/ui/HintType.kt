package com.example.android.hints.presentation.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.android.hints.R.string.*
import com.example.android.hints.R.drawable.*

enum class HintType(@StringRes val titleRes: Int, @DrawableRes val iconRes: Int) {
    RESTORE_PURCHASES(title_restore_purchases, ic_restore_purchases),
    FREE_100COINS(title_free_100coins, ic_watch_video_ads),
    ASK_FRIENDS(title_ask_friends, ic_ask_friends),
    EFFECTS(title_effects, ic_volume_up),
    RATE_APP(title_rate_app, ic_rate_app),
    REMOVE_ODD_LETTERS(title_remove_odd_letters, ic_remove_odd_letters),
    CONTACT_US(title_contact_us, ic_contact_us),
    OPEN_LETTER(title_open_letter, ic_open_letter),
    PRIVACY_POLICY(title_privacy_policy, ic_privacy_policy)
}