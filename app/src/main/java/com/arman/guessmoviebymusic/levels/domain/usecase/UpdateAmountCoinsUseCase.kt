package com.arman.guessmoviebymusic.levels.domain.usecase

import com.arman.guessmoviebymusic.base.domain.Either
import com.arman.guessmoviebymusic.base.domain.Failure
import com.arman.guessmoviebymusic.base.presentation.*
import com.arman.guessmoviebymusic.levels.domain.repository.CoinsRepository


class UpdateAmountCoinsUseCase(private val repository: CoinsRepository) : BaseUpdateCoinsUseCase() {


    override suspend fun run(params: Params): UpdateAmountCoinsEither {
        return try {
            val coins = repository.updateAmount(params)
            Either.Right(coins)
        } catch (e: Exception) {
            e.printStackTrace()
            Either.Left(Failure.FeatureFailure(e))
        }
    }

    data class Params(
        val amount: Int = 15
    )

}