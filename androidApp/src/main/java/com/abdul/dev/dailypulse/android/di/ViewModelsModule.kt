package com.abdul.dev.dailypulse.android.di

import com.abdul.dev.dailypulse.articles.presentation.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModules = module {
    viewModel {
        ArticlesViewModel(get())
    }
}