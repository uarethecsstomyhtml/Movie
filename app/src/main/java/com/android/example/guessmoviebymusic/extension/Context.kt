package com.android.example.guessmoviebymusic.extension

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.content.Intent.FLAG_ACTIVITY_NO_HISTORY
import android.content.Intent.FLAG_ACTIVITY_MULTIPLE_TASK
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.content.res.AppCompatResources
import com.android.example.guessmoviebymusic.base.presentation.MainActivity.Companion.APPODEAL_PRIVACY_POLICY_URL
import timber.log.Timber

private const val INTENT_TYPE_TEXT = "text/plain"
private const val APP_LINK_GOOGLE_PLAY_MARKET_URL = "market://details?id="
const val APP_LINK_GOOGLE_PLAY_SITE_URL = "https://play.google.com/store/apps/details?id="


fun Context?.getDrawableVectorRes(drawableId: Int): Drawable? {
    Timber.i("getDrawableVectorRes $drawableId")
    return this?.let { AppCompatResources.getDrawable(it, drawableId) }
}


fun Context.openPrivacyPolicy() {
    Timber.i("openPrivacyPolicy")
    val intent = Intent(ACTION_VIEW, Uri.parse(APPODEAL_PRIVACY_POLICY_URL))

    startActivity(intent)
}

fun Context.getApplicationName(): String {
    Timber.i("getApplicationName")
    val applicationInfo = applicationInfo
    val stringId = applicationInfo.labelRes
    return if (stringId == 0) applicationInfo.nonLocalizedLabel.toString() else getString(stringId)
}




//private fun Context.getColor(@ColorRes color: Int): Int {
//    Timber.i("getColor")
//    return ContextCompat.getColor(this, color)
//
//}

/**
 * If there is play market app, then call this application
 * else call site google play
 */
fun Context.openRateApp() {
    val googlePlaySiteUrl = "$APP_LINK_GOOGLE_PLAY_SITE_URL$packageName"
    val uriPlayMarket = Uri.parse("$APP_LINK_GOOGLE_PLAY_MARKET_URL$packageName" )
    Timber.i("openRateApp, linkGooglePlay: $googlePlaySiteUrl")
    Timber.i("openRateApp, uri: $uriPlayMarket")

    val intent = Intent(ACTION_VIEW, uriPlayMarket)
    intent.addFlags(FLAG_ACTIVITY_NO_HISTORY or FLAG_ACTIVITY_MULTIPLE_TASK)

    try {
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        startActivity(Intent(ACTION_VIEW, Uri.parse(googlePlaySiteUrl)))
    }
}