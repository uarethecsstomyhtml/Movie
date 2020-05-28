package com.example.android.ads

import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import timber.log.Timber


object DefaultBannerAd {

    private val adListener = object : AdListener() {
        override fun onAdLoaded() {
            Timber.i("onAdLoaded")
        }

        override fun onAdFailedToLoad(errorCode: Int) {
            Timber.i("onAdFailedToLoad, errorCode = $errorCode")
        }

        override fun onAdOpened() {
            Timber.i("onAdOpened")
        }

        override fun onAdClicked() {
            Timber.i("onAdClicked")
        }

        override fun onAdLeftApplication() {
            Timber.i("onAdLeftApplication")
        }

        override fun onAdClosed() {
            Timber.i("onAdClosed")
        }
    }

    fun showBanner(adView: AdView) {
        Timber.i("showBanner")
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        adView.adListener = adListener
    }


}