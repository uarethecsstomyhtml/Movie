package com.example.android.coins.domain.repository

import com.example.android.coins.domain.usecase.UpdateAmountCoinsUseCase


interface CoinsRepository {

    suspend fun getAmount(): Int

    suspend fun updateAmount(params: UpdateAmountCoinsUseCase.Params): Int
}