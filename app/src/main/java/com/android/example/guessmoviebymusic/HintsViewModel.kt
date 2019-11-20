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

class HintsViewModel() : ViewModel() {

    private val _hints = MutableLiveData<List<HintUi>>()
    val hints: LiveData<List<HintUi>>
            get() = _hints

    fun loadData() {
        Timber.d("loadData")
        _hints.value = generateHintsUi()
    }
}