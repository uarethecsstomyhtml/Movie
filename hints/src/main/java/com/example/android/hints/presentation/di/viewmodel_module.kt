package com.example.android.hints.presentation.di

import com.example.android.hints.presentation.ui.HintsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val hintsViewModelModule = module {
    viewModel { HintsViewModel() }
}