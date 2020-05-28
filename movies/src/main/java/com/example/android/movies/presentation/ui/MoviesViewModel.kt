package com.example.android.movies.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.movies.domain.usecase.GetMoviesByLevelUseCase
import com.example.android.movies.presentation.MovieDtoList
import com.example.android.movies.presentation.MovieUiList
import com.example.android.movies.presentation.MovieUiListResultLive
import com.example.android.movies.presentation.MovieUiListResultMutable
import com.example.android.network.domain.Failure
import com.example.android.ui_components.setError
import com.example.android.ui_components.setSuccess
import timber.log.Timber

class MoviesViewModel(private val getMoviesByLevelUseCase: GetMoviesByLevelUseCase) : ViewModel() {

    private val _movies = MovieUiListResultMutable()
    val movies: MovieUiListResultLive
        get() = _movies

    fun loadMoviesByLevelId(levelId: Long) {
        Timber.i("loadMoviesByLevelId, levelId = $levelId")
        val params = GetMoviesByLevelUseCase.Params(levelId)
        getMoviesByLevelUseCase.invoke(viewModelScope, params) {
            it.either(
                ::handleFailure,
                ::handleSuccess
            )
        }
    }

    private fun handleFailure(failure: Failure) {
        Timber.e("handleFailure: ${failure.exception}")
        _movies.setError(failure.exception)
    }

    private fun handleSuccess(list: MovieDtoList) {
        Timber.d("handleSuccess")
        _movies.setSuccess(mapToPresentation(list))
    }

    private fun mapToPresentation(movies: MovieDtoList): MovieUiList {
        Timber.d("mapToPresentation $movies")
        return movies.map {
            MovieUi(it.id, it.name, it.state, it.answerLetters) // Test
        }
    }
}