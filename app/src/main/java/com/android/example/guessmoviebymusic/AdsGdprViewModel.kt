package com.android.example.guessmoviebymusic

import androidx.annotation.StringRes
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

class AdsGdprViewModel() : ViewModel() {

    private val _descriptionRes = MutableLiveData<Int>()
    val descriptionRes: LiveData<Int>
            get() = _descriptionRes

    fun setDescriptionRes(@StringRes descriptionRes: Int) {
        Timber.d("loadData")
        _descriptionRes.value = descriptionRes
    }
}