package com.arman.guessmoviebymusic.levels.data.repository

import com.arman.guessmoviebymusic.di.CoinsDao
import com.arman.guessmoviebymusic.levels.domain.repository.CoinsRepository
import com.arman.guessmoviebymusic.levels.domain.usecase.UpdateAmountCoinsUseCase
import timber.log.Timber

class CoinsRepositoryImpl(private val dao: CoinsDao) : CoinsRepository {

    override suspend fun getAmount(): Int {
        Timber.d("getAmount ${dao.getAmount()}")

        return dao.getAmount()
    }

    override suspend fun updateAmount(params: UpdateAmountCoinsUseCase.Params) {
        val newAmount = dao.getAmount() + params.amount
        dao.updateAmount(amount = params.amount)
    }
}