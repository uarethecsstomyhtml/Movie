package com.android.example.guessmoviebymusic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.example.guessmoviebymusic.R
import com.android.example.guessmoviebymusic.`typealias`.MovieList
import com.android.example.guessmoviebymusic.`typealias`.MovieUiList
import com.android.example.guessmoviebymusic.base.domain.Failure
import com.android.example.guessmoviebymusic.base.presentation.ResultState
import com.android.example.guessmoviebymusic.extension.setLoading
import com.android.example.guessmoviebymusic.extension.setSuccess
import com.android.example.guessmoviebymusic.movies.domain.usecase.GetMoviesByLevelUseCase
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