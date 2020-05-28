package com.example.android.movies.presentation.ui.levels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.movies.domain.usecase.GetLevelsUseCase
import com.example.android.network.domain.Failure
import com.example.android.ui_components.setError
import com.example.android.ui_components.setLoading
import com.example.android.ui_components.setSuccess
import timber.log.Timber

class LevelsViewModel(private val getLevelsUseCase: GetLevelsUseCase) : ViewModel() {

    private val _levels = LevelUiListResultMutable()
    val levels: LevelUiListResultLive
        get() = _levels

    fun loadData() {
        Timber.d("loadData")
        _levels.setLoading()
        val params = GetLevelsUseCase.Params()
        getLevelsUseCase.invoke(viewModelScope, params) {
            it.either(
                ::handleFailure,
                ::handleSuccess
            )
        }
    }

    private fun handleFailure(failure: Failure) {
        Timber.e("handleFailure failure = ${failure.exception}")
        _levels.setError(failure.exception)
    }

    private fun handleSuccess(levels: LevelDtoList) {
        Timber.i("handleSuccess, levels = levels")
        _levels.setSuccess(mapToPresentation(levels))
    }

    private fun mapToPresentation(levels: LevelDtoList): LevelUiList {
        Timber.i("mapToPresentation, levels = $levels")
        return levels.map { LevelUi(it.id, it.name, it.imgRes, it.bgColor) }
    }

}