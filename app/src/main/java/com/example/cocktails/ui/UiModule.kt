package com.example.cocktails.ui

import com.example.cocktails.ui.homeScreen.HomeScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModels = module {
    viewModel{ HomeScreenViewModel(get()) }
}