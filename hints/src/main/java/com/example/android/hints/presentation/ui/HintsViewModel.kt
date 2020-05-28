package com.example.android.hints.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.hints.presentation.ui.HintType.*
import com.example.android.network.domain.Failure
import timber.log.Timber

class HintsViewModel(
//    private val getAmountCoinsUseCase: GetAmountCoinsUseCase,
//    private val updateAmountCoinsUseCase: UpdateAmountCoinsUseCase
) : ViewModel() {

    private val _hints = HintUiListMutable()
    val hints: HintUiListLive
        get() = _hints

    private val _amountCoins = MutableLiveData<Int>()
    val amountCoins: LiveData<Int>
        get() = _amountCoins

    private val _updateAmountCoins = MutableLiveData<Int>()
    val updateAmountCoins: LiveData<Int>
        get() = _updateAmountCoins


    fun loadHints() {
        Timber.d("loadData")
        _hints.value = listOf(
            HintUi(RESTORE_PURCHASES),
            HintUi(FREE_100COINS),
            HintUi(ASK_FRIENDS),
            HintUi(EFFECTS),
            HintUi(RATE_APP),
            HintUi(REMOVE_ODD_LETTERS, "50"),
            HintUi(OPEN_LETTER, "30"),
            HintUi(CONTACT_US),
            HintUi(PRIVACY_POLICY)
        )
    }

    fun loadAmountCoins() {
        Timber.d("loadAmountCoins")
//        getAmountCoinsUseCase.invoke(scope = viewModelScope, params = GetAmountCoinsUseCase.Params()) {
//            it.either(::getAmountCoinsHandleFailure, ::getAmountCoinsHandleSuccess)
//        }
    }

    private fun getAmountCoinsHandleFailure(failure: Failure) {
        Timber.e("handleFailureGetAmountCoins ${failure.exception}")
    }

    private fun getAmountCoinsHandleSuccess(amountCoins: Int) {
        Timber.d("handleSuccessGetAmountCoins $amountCoins")
        _amountCoins.postValue(amountCoins)
    }

    fun updateAmountCoins(amount: Int) {
//        val params = UpdateAmountCoinsUseCase.Params(amount = amount)
//        updateAmountCoinsUseCase.invoke(viewModelScope, params) {
//            it.either(::handleFailureUpdateAmountCoins, ::handleSuccessUpdateAmountCoins)
//        }
    }

    private fun handleFailureUpdateAmountCoins(failure: Failure) {
        Timber.e("updateAmountCoinsHandleFailure ${failure.exception}")
    }

    @Suppress("UNUSED_PARAMETER")
    private fun handleSuccessUpdateAmountCoins(newAmount: Int) {
        Timber.d("updateAmountCoinsHandleSuccess")
        _updateAmountCoins.postValue(newAmount)
    }
}