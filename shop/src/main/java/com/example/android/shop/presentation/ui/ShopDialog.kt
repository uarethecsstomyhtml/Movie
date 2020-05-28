package com.example.android.shop.presentation.ui

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.android.shop.R
import com.example.android.shop.presentation.ui.ShopType.*
import com.example.android.sound_components.SOUND_UI_TAP_NAME
import com.example.android.ui_components.BaseFullDialogFragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.dialog_shop.*
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named
import timber.log.Timber

class ShopDialog : BaseFullDialogFragment() {

    private lateinit var adapter: GroupAdapter<GroupieViewHolder>
    private val viewModel: ShopViewModel by inject()

    private val soundUiTap: Int by inject(named(SOUND_UI_TAP_NAME))

    override fun getLayout() = R.layout.dialog_shop

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Timber.d("onActivityCreated")
        super.onActivityCreated(savedInstanceState)
        setupAdapter()
        loadData()
        viewModel.shop.observe(viewLifecycleOwner, Observer(::onShopChange))
        toolbar.setNavigationOnClickListener(::closeDialog)
    }

    private fun loadData() {
        Timber.d("loadData")
        viewModel.loadData()
    }

    private fun setupAdapter() {
        Timber.i("setupAdapter")
        adapter = GroupAdapter()
        rvShop.adapter = adapter
    }

    private fun onShopChange(shopUiList: ShopUiList) {
        Timber.d("onShopChange, shopUiList = $shopUiList")
        showSuccess(shopUiList)
    }

    private fun showSuccess(shopUiList: ShopUiList) {
        Timber.d("showSuccess, shopUiList = $shopUiList")
        for (item in shopUiList) adapter.add(ShopItem(item, soundUiTap, ::onShopItemClick))
    }

    private fun onShopItemClick(item: ShopUi) {
        Timber.d("onShopClick $item")
        when (item.type) {
            COINS_350 -> Toast.makeText(context, "COINS 350", Toast.LENGTH_LONG).show()
            COINS_750 -> Toast.makeText(context, "COINS 750", Toast.LENGTH_LONG).show()
            COINS_2000 -> Toast.makeText(context, "COINS 2000", Toast.LENGTH_LONG).show()
            COINS_4500 -> Toast.makeText(context, "COINS 4500", Toast.LENGTH_LONG).show()
            COINS_15000 -> Toast.makeText(context, "COINS 15000", Toast.LENGTH_LONG).show()
            BLOCK_ADS -> Toast.makeText(context, "BLOCK ADS", Toast.LENGTH_LONG).show()
            FREE_100_COINS -> Toast.makeText(context, "FREE 100 COINS", Toast.LENGTH_LONG).show()
        }
    }
}