package com.example.android.movies.presentation.ui.victory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.network.domain.Failure
import timber.log.Timber

class VictoryViewModel(
//    private val getAmountCoinsUseCase: GetAmountCoinsUseCase,
//    private val updateAmountCoinsUseCase: UpdateAmountCoinsUseCase
) : ViewModel() {

    private val _amountCoins = MutableLiveData<Int>()
    val amountCoins: LiveData<Int>
        get() = _amountCoins

    private val _countStars = MutableLiveData<Int>()
    val countStars: LiveData<Int>
        get() = _countStars

    fun getCountStars() {
        Timber.d("getCountStars")
    }

    fun loadAmountCoins() {
        Timber.i("loadAmountCoins")
//        val params = GetAmountCoinsUseCase.Params()
//        getAmountCoinsUseCase.invoke(viewModelScope, params) {
//            it.either(::getAmountCoinsHandleFailure, ::getAmountCoinsHandleSuccess)
//        }
    }

    private fun getAmountCoinsHandleFailure(failure: Failure) {
        Timber.e("handleFailureGetAmountCoins ${failure.exception}")
    }

    @Suppress("UNUSED_PARAMETER")
    private fun getAmountCoinsHandleSuccess(amount: Int) {
        Timber.d("handleSuccessGetAmountCoins $amount")
        _amountCoins.postValue(amount)
    }

    fun updateAmountCoins() {
        Timber.i("updateAmountCoins")
//        val params = UpdateAmountCoinsUseCase.Params(amount = GUESSED_MOVIE.amount)
//        updateAmountCoinsUseCase.invoke(viewModelScope, params) {
//            it.either(::updateAmountCoinsHandleFailure, ::updateAmountCoinsHandleSuccess)
    }

    private fun updateAmountCoinsHandleFailure(failure: Failure) {
        Timber.e("updateAmountCoinsHandleFailure ${failure.exception}")
    }

    @Suppress("UNUSED_PARAMETER")
    private fun updateAmountCoinsHandleSuccess(newAmount: Int) {
        Timber.d("updateAmountCoinsHandleSuccess")
    }


}