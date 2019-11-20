package com.android.example.guessmoviebymusic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import com.android.example.guessmoviebymusic.HintType.*
import com.android.example.guessmoviebymusic.`typealias`.HintUiList
import com.android.example.guessmoviebymusic.extension.openPrivacyPolicy
import com.android.example.guessmoviebymusic.extension.openRateApp
//import com.appodeal.ads.Appodeal
import kotlinx.android.synthetic.main.dialog_hints.*
import org.koin.android.ext.android.inject
import timber.log.Timber

class HintsDialog : DialogFragment() {

    private lateinit var adapter: HintsAdapter
    private val viewModel: HintsViewModel by inject()

    override fun onStart() {
        Timber.d("onStart")
        super.onStart()
        dialog?.window?.apply {
            setLayout(MATCH_PARENT, MATCH_PARENT)
            setWindowAnimations(R.style.AppTheme_Slide)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Timber.d("onActivityCreated")
        return inflater.inflate(R.layout.dialog_hints, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("onCreate")
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.AppTheme_FullScreenDialog)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Timber.d("onActivityCreated")
        super.onActivityCreated(savedInstanceState)
        initAdapter()
        initRv()
        loadData()
        observeHintsChange()
        toolbar.setNavigationOnClickListener(::closeDialog)
    }

    @Suppress("UNUSED_PARAMETER")
    private fun closeDialog(view: View) {
        Timber.d("onClickClose $view")
        dismiss()
    }

    private fun loadData() {
        Timber.d("loadData")
        viewModel.loadData()
    }

    private fun initAdapter() {
        Timber.d("initAdapter")
        adapter = HintsAdapter(::onHintClick)
    }

    private fun initRv() {
        Timber.d("initRv")
        rvHints.adapter = adapter
    }

    private fun observeHintsChange() {
        Timber.d("observeLevelsStateChange")
        viewModel.hints.observe(viewLifecycleOwner, Observer(::onHintsChange))
    }

    private fun onHintsChange(list: HintUiList) {
        Timber.d("onHintsChange $list")
        showSuccess(list)
    }

    private fun showSuccess(list: HintUiList) {
        Timber.d("showSuccess $list")
        adapter.submitList(list)
    }

    private fun onHintClick(item: HintUi) {
        Timber.d("onHintClick $item")
        when (item.hintType) {
            FREE_100_COINS -> watchVideoAds()
            ASK_FRIENDS -> askFriends()
            EFFECTS -> changeStateEffects()
            RATE_APP -> openRateApp()
            REMOVE_ODD_LETTERS -> removeOddLetters()
            OPEN_LETTER -> openLetter()
            PRIVACY_POLICY -> openPrivacyPolicy()
        }
    }

    private fun watchVideoAds() {
        Timber.d("watchVideoAds")
//        activity?.let { Appodeal.show(it, Appodeal.REWARDED_VIDEO) }
    }

    private fun askFriends() {
        Timber.d("askFriends")
        TODO()
    }

    private fun changeStateEffects() {
        Timber.d("askFriends")
        TODO()
    }

    private fun openRateApp() {
        Timber.d("openRateApp")
        context?.openRateApp()
    }

    private fun removeOddLetters() {
        Timber.d("removeOddLetters")
        TODO()
    }

    private fun openLetter() {
        Timber.d("openLetter")
        TODO()
    }

    private fun openPrivacyPolicy() {
        Timber.d("openPrivacyPolicy")
        context?.openPrivacyPolicy()
    }
}