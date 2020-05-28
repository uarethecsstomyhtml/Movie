package com.example.android.coins.presentation

import com.example.android.coins.domain.usecase.GetAmountCoinsUseCase
import com.example.android.coins.domain.usecase.UpdateAmountCoinsUseCase
import com.example.android.network.domain.BaseUseCase
import com.example.android.network.domain.Either
import com.example.android.network.domain.Failure

/**
 * Use Cases
 */
typealias BaseGetCoinsUseCase = BaseUseCase<Int, GetAmountCoinsUseCase.Params>
typealias BaseUpdateCoinsUseCase = BaseUseCase<Int, UpdateAmountCoinsUseCase.Params>

/**
 * Either
 */
typealias IntEither = Either<Failure, Int>