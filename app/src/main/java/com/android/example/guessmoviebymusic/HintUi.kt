package com.android.example.guessmoviebymusic

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.DiffUtil
import com.android.example.guessmoviebymusic.HintType.*


data class HintUi (
    val id: Long,
    val name: String,
    val hintType: HintType,
    @DrawableRes val imgRes: Int,
    val price: String = ""
) {
    val priceVisibility  = if (price.isNotBlank()) VISIBLE else GONE

        companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<HintUi>() {
            override fun areItemsTheSame(oldItem: HintUi, newItem: HintUi): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: HintUi, newItem: HintUi): Boolean =
                oldItem == newItem
        }
    }
}

fun generateHintsUi(): MutableList<HintUi> {
    val list = mutableListOf<HintUi>()
//    list.add(HintUi(1, "У вас есть 750 монет", R.drawable.ic_hint_open_letter)) // To Top
    list.add(HintUi(2, "Восстановить покупки", FREE_100_COINS, R.drawable.ic_hint_restore_purchases))
    list.add(HintUi(2, "Бесплатно 100 монет", FREE_100_COINS, R.drawable.ic_hint_watch_video_ads))
    list.add(HintUi(3, "Спросить у друзей", ASK_FRIENDS, R.drawable.ic_hint_ask_friends))
    list.add(HintUi(4, "Эффекты", EFFECTS, R.drawable.ic_hint_volume_up))
    list.add(HintUi(5, "Оценить приложение", RATE_APP, R.drawable.ic_hint_rate_app))
    list.add(HintUi(5, "Убрать лишние буквы", REMOVE_ODD_LETTERS, R.drawable.ic_hint_delete_odd_letters, "50"))
    list.add(HintUi(6, "Открыть букву", OPEN_LETTER, R.drawable.ic_hint_open_letter, "30"))
    list.add(HintUi(6, "Свяжитесь с нами", OPEN_LETTER, R.drawable.ic_hint_contact_us))
    list.add(HintUi(6, "Политика конфиденциальности", PRIVACY_POLICY, R.drawable.ic_hint_privacy_policy))

    return list
}
