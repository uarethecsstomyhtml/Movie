package com.example.android.analytics

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

object DefaultFirebaseAnalytics {

    fun setEventLevelUp(firebaseAnalytics: FirebaseAnalytics, level: Long) {
        val bundle = Bundle()
        bundle.putLong(FirebaseAnalytics.Param.LEVEL, level)
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.LEVEL_UP, bundle)
    }

    fun setEventLevelStart(firebaseAnalytics: FirebaseAnalytics, level: Long) {
        val bundle = Bundle()
        bundle.putLong(FirebaseAnalytics.Param.LEVEL_NAME, level)
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.LEVEL_START, bundle)
    }

    fun setEventLevelEnd(firebaseAnalytics: FirebaseAnalytics, level: Long, isSuccess: Boolean) {
        val bundle = Bundle()
        bundle.putLong(FirebaseAnalytics.Param.LEVEL_NAME, level)
        bundle.putString(FirebaseAnalytics.Param.SUCCESS, isSuccess.toString())
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.LEVEL_END, bundle)
    }

    fun setEventEarnVirtualCurrency(
        firebaseAnalytics: FirebaseAnalytics,
        virtualCurrencyName: String,
        amount: Int
    ) {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.VIRTUAL_CURRENCY_NAME, virtualCurrencyName)
        bundle.putLong(FirebaseAnalytics.Param.VALUE, amount.toLong())
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.EARN_VIRTUAL_CURRENCY, bundle)
    }

    fun setEventSpendVirtualCurrency(
        firebaseAnalytics: FirebaseAnalytics,
        virtualCurrencyName: String,
        amount: Int
    ) {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, virtualCurrencyName)
        bundle.putString(FirebaseAnalytics.Param.VIRTUAL_CURRENCY_NAME, virtualCurrencyName)
        bundle.putLong(FirebaseAnalytics.Param.VALUE, amount.toLong())
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SPEND_VIRTUAL_CURRENCY, bundle)
    }

}