package com.android.example.guessmoviebymusic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.android.example.guessmoviebymusic.ShopType.*
import com.android.example.guessmoviebymusic.`typealias`.ShopUiList
import kotlinx.android.synthetic.main.dialog_shop.*
import org.koin.android.ext.android.inject
import timber.log.Timber

class ShopDialog : DialogFragment() {

    private lateinit var adapter: ShopAdapter
    private val viewModel: ShopViewModel by inject()

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
        return inflater.inflate(R.layout.dialog_shop, container, false)
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
        adapter = ShopAdapter(::onShopClick)
    }

    private fun initRv() {
        Timber.d("initRv")
        rvShop.adapter = adapter
    }

    private fun observeHintsChange() {
        Timber.d("observeLevelsStateChange")
        viewModel.shop.observe(viewLifecycleOwner, Observer(::onShopChange))
    }

    private fun onShopChange(list: ShopUiList) {
        Timber.d("onShopChange $list")
        showSuccess(list)
    }

    private fun showSuccess(list: ShopUiList) {
        Timber.d("showSuccess $list")
        adapter.submitList(list)
    }

    private fun onShopClick(item: ShopUi) {
        Timber.d("initAdapter $item")
        when (item.type) {
            COINS_350 -> ""//watchVideoAds()
            COINS_750 -> ""//askFriends()
            COINS_2000 -> ""//changeStateEffects()
            COINS_4500 -> ""//openRateApp()
            COINS_15000 -> ""//removeOddLetters()
            BLOCK_ADS -> ""//openLetter()
            FREE_100_COINS -> ""//openPrivacyPolicy()
        }
    }
}