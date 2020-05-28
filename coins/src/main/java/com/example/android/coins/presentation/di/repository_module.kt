package com.example.android.coins.presentation.di

import com.example.android.coins.data.repository.DefaultCoinsRepository
import com.example.android.coins.domain.repository.CoinsRepository
import org.koin.dsl.module

val coinsRepositoryModule = module {
    factory { DefaultCoinsRepository(coinsDao = get()) as CoinsRepository }
}