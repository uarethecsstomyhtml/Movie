package com.example.android.ads

import android.content.Context
import android.os.Bundle
import com.example.android.ui_components.BuildConfig
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.firebase.analytics.FirebaseAnalytics
import timber.log.Timber

private const val TEST_INTERSTITIAL_AD_ID = "ca-app-pub-3940256099942544/1033173712"
private const val RELEASE_INTERSTITIAL_AD_ID = "RELEASE"

class DefaultInterstitialAd(private val context: Context) {

    private lateinit var interstitialAd: InterstitialAd

    private val adListener = object : AdListener() {
        override fun onAdLoaded() {
            Timber.i("onAdClicked")
        }

        override fun onAdFailedToLoad(errorCode: Int) {
            Timber.i("onAdFailedToLoad, errorCode = $errorCode")
        }

        override fun onAdOpened() {
            Timber.i("onAdClicked")
        }

        override fun onAdClicked() {
            Timber.i("onAdClicked")
        }

        override fun onAdLeftApplication() {
            Timber.i("onAdClicked")
        }

        override fun onAdClosed() {
            Timber.i("onAdClosed")
        }
    }

    fun initInterstitialAd() {
        Timber.i("initInterstitialAds")
        interstitialAd = InterstitialAd(context)
        interstitialAd.adUnitId =
            if (BuildConfig.DEBUG) TEST_INTERSTITIAL_AD_ID else RELEASE_INTERSTITIAL_AD_ID
        interstitialAd.loadAd(AdRequest.Builder().build())
        interstitialAd.adListener = adListener
    }


    fun showInterstitialAd() {
        Timber.i("showInterstitialAds")
        if (interstitialAd.isLoaded) interstitialAd.show()
    }
}