package com.android.example.guessmoviebymusic.base.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.example.guessmoviebymusic.R
//import com.appodeal.ads.Appodeal


/**
 * Base Activity for all fragments.
 */
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    companion object {
        const val BASE_LINK_GOOGLE_PLAY_SITE = "https://play.google.com/store/apps/details?id="
        const val APPODEAL_PRIVACY_POLICY_URL = "https://www.appodeal.com/privacy-policy"
        private const val APPODEAL_APP_KEY = "APPODEAL_APP_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAds()
    }

    private fun initAds() {
//        val adTypes = Appodeal.BANNER or Appodeal.INTERSTITIAL or Appodeal.REWARDED_VIDEO
//        Appodeal.initialize(this, APPODEAL_APP_KEY, adTypes, false)//consentValue)
    }

    override fun onDestroy() {
        super.onDestroy()
//        Appodeal.destroy(Appodeal.BANNER)
    }
}
