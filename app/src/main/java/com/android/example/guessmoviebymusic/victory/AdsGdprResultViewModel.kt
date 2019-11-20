package com.android.example.guessmoviebymusic.victory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.example.guessmoviebymusic.extension.call
import timber.log.Timber

class AdsGdprResultViewModel : ViewModel() {

    private val _close = MutableLiveData<Unit>()
    val close: LiveData<Unit>
            get() = _close

    fun callClose() {
        Timber.d("callClose")
        _close.call()
    }
}