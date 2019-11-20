package com.arman.guessmoviebymusic.levels.domain.repository

import com.arman.guessmoviebymusic.levels.domain.usecase.UpdateAmountCoinsUseCase

interface CoinsRepository {

    suspend fun getAmount(): Int

    suspend fun updateAmount(params: UpdateAmountCoinsUseCase.Params): Unit
}