package com.abdul.dev.dailypulse.articles.di

import com.abdul.dev.dailypulse.articles.data.ArticlesDataSource
import com.abdul.dev.dailypulse.articles.data.ArticlesRepository
import com.abdul.dev.dailypulse.articles.data.ArticlesService
import com.abdul.dev.dailypulse.articles.domain.ArticlesUseCase
import com.abdul.dev.dailypulse.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {

    single<ArticlesService> {
        ArticlesService(get())
    }

    single<ArticlesUseCase> {
        ArticlesUseCase(get())
    }

    single<ArticlesViewModel> {
        ArticlesViewModel(get())
    }

    single<ArticlesDataSource> {
        ArticlesDataSource(get())
    }

    single<ArticlesRepository> {
        ArticlesRepository(get(), get())
    }
}