package com.example.android.hints.presentation.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.android.ads.DefaultRewardAd
import com.example.android.hints.R
import com.example.android.hints.presentation.ui.HintType.*
import com.example.android.sound_components.SOUND_UI_TAP_NAME
import com.example.android.ui_components.BaseFullDialogFragment
import com.example.android.ui_components.coinIncreaseAnimation
import com.example.android.ui_components.openPrivacyPolicy
import com.example.android.ui_components.openRateApp
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.dialog_hints.*
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named
import timber.log.Timber


class HintsDialog : BaseFullDialogFragment() {

    private lateinit var adapter: GroupAdapter<GroupieViewHolder>
    private val viewModel: HintsViewModel by inject()
    private lateinit var defaultRewardAd: DefaultRewardAd

    private val soundUiTap: Int by inject(named(SOUND_UI_TAP_NAME))

    override fun getLayout() = R.layout.dialog_hints

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Timber.d("onActivityCreated")
        super.onActivityCreated(savedInstanceState)
        initRewardedAd()
        setupAdapter()
        loadData()
        loadAmountCoins()

        toolbar.setNavigationOnClickListener(::closeDialog)
        viewModel.amountCoins.observe(this, Observer(::changeStateAmountCoins))
        viewModel.updateAmountCoins.observe(this, Observer(::changeStateUpdateAmountCoins))
        viewModel.hints.observe(viewLifecycleOwner, Observer(::onHintsChange))
    }

    private fun initRewardedAd() {
        defaultRewardAd = DefaultRewardAd()
        defaultRewardAd.initRewardAds(requireContext())
    }

    private fun setupAdapter() {
        Timber.d("setupAdapter")
        adapter = GroupAdapter()
        rvHints.adapter = adapter
    }

    private fun loadData() {
        Timber.d("loadData")
        viewModel.loadHints()
    }

    private fun loadAmountCoins() {
        Timber.d("loadAmountCoins")
        viewModel.loadAmountCoins()
    }

    private fun onHintsChange(hints: HintUiList) {
        Timber.d("onHintsChange, hints = $hints")
        for (hint in hints) adapter.add(HintItem(hint, soundUiTap, ::onHintClick))
    }

    private fun changeStateAmountCoins(amountCoins: Int) {
        Timber.d("changeStateAmountCoins, amountCoins = $amountCoins")
        tvAmountCoins.text = amountCoins.toString()
    }

    private fun changeStateUpdateAmountCoins(newAmount: Int) {
        Timber.d("changeStateUpdateAmountCoins, newAmount = $newAmount")
        val oldAmount = tvAmountCoins.text.toString().toInt()
        tvAmountCoins.coinIncreaseAnimation(oldAmount, newAmount)
    }

    private fun onHintClick(hint: HintUi) {
        Timber.d("onHintClick, hint = $hint")
        when (hint.type) {
            RESTORE_PURCHASES -> ""
            FREE_100COINS -> watchVideoAds()
            ASK_FRIENDS -> askFriends()
            EFFECTS -> changeStateEffects()
            RATE_APP -> openRateApp()
            REMOVE_ODD_LETTERS -> removeOddLetters()
            OPEN_LETTER -> openLetter()
            CONTACT_US -> ""
            PRIVACY_POLICY -> openPrivacyPolicy()
        }
    }

    private fun watchVideoAds() {
        Timber.i("watchVideoAds")
        defaultRewardAd.showRewardAds(activity, ::onRewardEarnedReward)
    }

    private fun onRewardEarnedReward(amount: Int) {
        Timber.i("onRewardEarnedReward")
        viewModel.updateAmountCoins(amount)
    }

    private fun askFriends() {
        Timber.d("askFriends")
        TODO()
    }

    private fun changeStateEffects() {
        Timber.d("changeStateEffects")
        TODO()
    }

    private fun openRateApp() {
        Timber.d("openRateApp")
        context?.openRateApp()
    }

    private fun removeOddLetters() {
        Timber.d("removeOddLetters")
//        viewModel.updateAmountCoins(USED_HINT_REMOVE_ODD_LETTERS.amount)
        // TODO()
    }

    private fun openLetter() {
        Timber.d("openLetter")
//        viewModel.updateAmountCoins(USED_HINT_OPEN_LETTER.amount)
        TODO()
    }

    private fun openPrivacyPolicy() {
        Timber.d("openPrivacyPolicy")
        context?.openPrivacyPolicy()
    }
}