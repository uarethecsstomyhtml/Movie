package com.example.android.ui_components

import android.animation.ValueAnimator
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.content.Intent.FLAG_ACTIVITY_NO_HISTORY
import android.content.Intent.FLAG_ACTIVITY_MULTIPLE_TASK
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.media.SoundPool
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.MutableLiveData


private const val APP_LINK_GOOGLE_PLAY_MARKET_URL = "market://details?id="
const val APP_LINK_GOOGLE_PLAY_SITE_URL = "https://play.google.com/store/apps/details?id="
const val APPODEAL_PRIVACY_POLICY_URL = ""

/**
 * Context
 */
fun Context.getApplicationName(): String {
    val stringId = applicationInfo.labelRes
    return if (stringId == 0) applicationInfo.nonLocalizedLabel.toString() else getString(stringId)
}

fun Context?.getDrawableVector(drawableId: Int): Drawable? {
    return this?.let { AppCompatResources.getDrawable(it, drawableId) }
}

fun Context.openPrivacyPolicy() {
    val intent = Intent(ACTION_VIEW, Uri.parse(APPODEAL_PRIVACY_POLICY_URL))
    startActivity(intent)
}

fun Context.openRateApp() {
    val playMarket = Uri.parse("$APP_LINK_GOOGLE_PLAY_MARKET_URL$packageName")

    val intent = Intent(ACTION_VIEW, playMarket)
    intent.addFlags(FLAG_ACTIVITY_NO_HISTORY or FLAG_ACTIVITY_MULTIPLE_TASK)

    try {
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        val siteUrl = "$APP_LINK_GOOGLE_PLAY_SITE_URL$packageName"
        startActivity(Intent(ACTION_VIEW, Uri.parse(siteUrl)))
    }
}

///**
// * ImageView
// */
//fun ImageView.loadRes(drawableRes: Int) {
//    Glide.with(this.context)
//        .load(drawableRes)
//        .centerCrop()
//        .transition(DrawableTransitionOptions.withCrossFade()).into(this)
//}

/**
 * MutableLiveData
 */
fun <T> MutableLiveData<ResultState<T>>.setSuccess(data: T) =
    postValue(ResultState.Success(data))

fun <T> MutableLiveData<ResultState<T>>.setLoading() =
    postValue(ResultState.Loading(null))

fun <T> MutableLiveData<ResultState<T>>.setError(e: Throwable, message: T? = null) =
    postValue(ResultState.Error(e, message))

fun <T> MutableLiveData<T>.call() = postValue(null)

/**
 * SoundPool
 */
fun SoundPool.play(sound: Int) {
    play(sound, 1f, 1f, 1, 0, 1f)
}

/**
 * String
 */
fun String.getColor(): Int {
    return Color.parseColor(this)
}

///**
// * SwipeRefreshLayout
// */
//fun SwipeRefreshLayout.stopRefreshing() {
//    isRefreshing = false
//}

/**
 * TextView
 */
fun TextView.coinIncreaseAnimation(oldAmount: Int, newAmount: Int) {
    with(ValueAnimator.ofInt(oldAmount, newAmount)) {
        duration = 2000
        addUpdateListener { text = animatedValue.toString() }
        start()
    }
}

/**
 * View
 */
fun View.visible() {
    visibility = View.VISIBLE
}

@SuppressWarnings("Later will be using")
fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.setSafeOnClickListener(sound: Int, onSafeClick: (View) -> Unit) {
    val safeClickListener = SafeClickListener(sound) { onSafeClick(it) }
    setOnClickListener(safeClickListener)
}

/**
 * ViewGroup
 */
fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)


