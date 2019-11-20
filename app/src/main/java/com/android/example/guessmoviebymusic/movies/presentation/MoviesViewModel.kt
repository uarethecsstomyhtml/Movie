package com.android.example.guessmoviebymusic.movies.presentation

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

class MoviesViewModel(private val moviesByLevelUseCase: GetMoviesByLevelUseCase) : ViewModel() {

    private val _state = MutableLiveData<ResultState<MovieUiList>>().apply {
        Timber.d("setLoading")
        setLoading()
    }
    val state: LiveData<ResultState<MovieUiList>>
        get() = _state

    fun loadData(levelId: Long) {
        val params = GetMoviesByLevelUseCase.Params(levelId)
        moviesByLevelUseCase.invoke(viewModelScope, params) { it.either(::handleFailure, ::handleSuccess )}
    }

    private fun handleFailure(failure: Failure) {
        Timber.e("handleFailure: ${failure.exception}")
        //state.value = ResultState.Error(failure)
    }

    private fun handleSuccess(list: MovieList) {
        Timber.d("handleSuccess")
        _state.setSuccess(mapToPresentation(list))
    }

    private fun mapToPresentation(movies: MovieList): MovieUiList {
        Timber.d("mapToPresentation $movies")
        return movies.map {
            val imgRes = if (it.isGuessed) R.drawable.ic_hint_rate_app else R.drawable.ic_lock

            MovieUi(it.id, it.name, imgRes)
        }
    }
}