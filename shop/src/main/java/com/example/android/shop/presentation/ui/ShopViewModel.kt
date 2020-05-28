package com.example.android.shop.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShopViewModel() : ViewModel() {

    private val _shop = MutableLiveData<List<ShopUi>>()
    val shop: LiveData<List<ShopUi>>
        get() = _shop

    fun loadData() {
        Timber.d("loadData")
        _shop.value = generateShopUi()
    }
}