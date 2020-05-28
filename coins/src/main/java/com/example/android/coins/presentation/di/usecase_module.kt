package com.example.android.coins.presentation.di

import com.example.android.coins.domain.usecase.GetAmountCoinsUseCase
import com.example.android.coins.domain.usecase.UpdateAmountCoinsUseCase
import org.koin.dsl.module

val coinsUseCaseModule = module {
    factory { GetAmountCoinsUseCase(coinsRepository = get()) }
    factory { UpdateAmountCoinsUseCase(coinsRepository = get()) }
}