package com.example.android.coins.data.repository

import com.example.android.coins.data.local.CoinsDao
import com.example.android.coins.domain.repository.CoinsRepository
import com.example.android.coins.domain.usecase.UpdateAmountCoinsUseCase
import timber.log.Timber

class DefaultCoinsRepository(private val coinsDao: CoinsDao) : CoinsRepository {

    override suspend fun getAmount(): Int {
        Timber.i("getAmount, result = ${coinsDao.getAmount()}")

        return coinsDao.getAmount()
    }

    override suspend fun updateAmount(params: UpdateAmountCoinsUseCase.Params): Int {
        Timber.i("updateAmount, params = $params")
        val newAmount = coinsDao.getAmount() + params.amount
        coinsDao.updateAmount(amount = newAmount)

        return newAmount
    }
}