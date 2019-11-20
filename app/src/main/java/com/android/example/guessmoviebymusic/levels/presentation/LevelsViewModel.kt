package com.android.example.guessmoviebymusic.levels.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.example.guessmoviebymusic.base.domain.Failure
import com.android.example.guessmoviebymusic.base.presentation.ResultState
import com.android.example.guessmoviebymusic.`typealias`.LevelList
import com.android.example.guessmoviebymusic.`typealias`.LevelUiList
import com.android.example.guessmoviebymusic.extension.setLoading
import com.android.example.guessmoviebymusic.extension.setSuccess
import com.android.example.guessmoviebymusic.levels.domain.usecase.GetLevelsUseCase
import timber.log.Timber

class LevelsViewModel(private val getLevelsUseCase: GetLevelsUseCase) : ViewModel() {

    private val _state = MutableLiveData<ResultState<LevelUiList>>().apply {
        Timber.d("setLoading")
        setLoading()
    }
    val state: LiveData<ResultState<LevelUiList>>
        get() = _state

    fun loadData() {
        Timber.d("loadData")
        val params = GetLevelsUseCase.Params()
        getLevelsUseCase.invoke(viewModelScope, params) { it.either(::handleFailure, ::handleSuccess) }
    }

    private fun handleFailure(failure: Failure) {
        Timber.e("handleFailure ${failure.exception}")
//        state.value = ResultState.Error(failure)
    }

    private fun handleSuccess(list: LevelList) {
        Timber.d("handleSuccess")
        _state.setSuccess(mapToPresentation(list))
    }

    private fun mapToPresentation(levels: LevelList): LevelUiList {
        Timber.d("mapToPresentation $levels")
        return levels.map {
            LevelUi(it.id, it.name, it.imgUrl, it.bgColor)
        }
    }

}