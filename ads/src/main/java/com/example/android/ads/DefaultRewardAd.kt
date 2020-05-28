package com.example.android.ads

import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdCallback
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import timber.log.Timber


private const val TEST_REWARD_AD_ID = "ca-app-pub-3940256099942544/5224354917"
private const val RELEASE_REWARD_AD_ID = "RELEASE_REWARD_AD_ID"

class DefaultRewardAd {

    private lateinit var rewardedAd: RewardedAd

    private val rewardedAdLoadCallback = object : RewardedAdLoadCallback() {
        override fun onRewardedAdLoaded() {
            Timber.i("onRewardedAdLoaded")
        }

        override fun onRewardedAdFailedToLoad(errorCode: Int) { // Ad failed to load.
            Timber.i("onRewardedAdFailedToLoad, errorCode = $errorCode")
        }
    }

    fun initRewardAds(context: Context) {
        rewardedAd = RewardedAd(context, TEST_REWARD_AD_ID)
        rewardedAd.loadAd(AdRequest.Builder().build(), rewardedAdLoadCallback)
    }

    fun showRewardAds(activity: FragmentActivity?, onUserEarnedReward: (Int) -> Unit) {
        val rewardedAdCallback = object : RewardedAdCallback() {
            override fun onRewardedAdOpened() {
                Timber.i("onRewardedAdOpened")
            }

            override fun onRewardedAdClosed() {
                Timber.i("onRewardedAdClosed")
            }

            override fun onUserEarnedReward(reward: RewardItem) {
                Timber.i("onUserEarnedReward, reward = $reward")
                onUserEarnedReward(reward.amount)
            }

            override fun onRewardedAdFailedToShow(errorCode: Int) {
                Timber.i("onRewardedAdFailedToShow, errorCode = $errorCode")
            }
        }
        rewardedAd.show(activity, rewardedAdCallback)
    }
}