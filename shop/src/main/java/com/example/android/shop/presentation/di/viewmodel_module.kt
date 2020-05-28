package com.example.android.shop.presentation.di

import com.example.android.shop.presentation.ui.ShopViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val shopViewModelModule = module {
    viewModel { ShopViewModel() }
}