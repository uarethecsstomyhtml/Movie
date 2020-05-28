package com.example.android.coins.domain.usecase

import com.example.android.coins.domain.repository.CoinsRepository
import com.example.android.coins.presentation.BaseUpdateCoinsUseCase
import com.example.android.coins.presentation.IntEither
import com.example.android.network.domain.Either
import com.example.android.network.domain.Failure


class UpdateAmountCoinsUseCase(private val coinsRepository: CoinsRepository) :
    BaseUpdateCoinsUseCase() {


    override suspend fun run(params: Params): IntEither {
        return try {
            val coins = coinsRepository.updateAmount(params)
            Either.Right(coins)
        } catch (e: Exception) {
            e.printStackTrace()
            Either.Left(Failure.FeatureFailure(e))
        }
    }

    data class Params(
        val amount: Int
    )

}