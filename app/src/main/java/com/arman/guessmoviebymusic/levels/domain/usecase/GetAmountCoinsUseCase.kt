package com.arman.guessmoviebymusic.levels.domain.usecase

import com.arman.guessmoviebymusic.base.domain.Either
import com.arman.guessmoviebymusic.base.domain.Failure
import com.arman.guessmoviebymusic.base.presentation.*
import com.arman.guessmoviebymusic.levels.domain.repository.CoinsRepository


class GetAmountCoinsUseCase(private val repository: CoinsRepository) : BaseGetCoinsUseCase() {


    override suspend fun run(params: Params): AmountCoinsEither {
        return try {
            val coins = repository.getAmount()
            Either.Right(coins)
        } catch (e: Exception) {
            e.printStackTrace()
            Either.Left(Failure.FeatureFailure(e))
        }
    }

    data class Params(
        val isRemote: Boolean = false
    )

}