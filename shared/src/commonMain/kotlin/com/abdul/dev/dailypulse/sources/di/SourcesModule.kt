package com.abdul.dev.dailypulse.sources.di

import com.abdul.dev.dailypulse.sources.data.SourcesDataSource
import com.abdul.dev.dailypulse.sources.data.SourcesRepository
import com.abdul.dev.dailypulse.sources.data.SourcesService
import com.abdul.dev.dailypulse.sources.domain.SourcesUseCase
import com.abdul.dev.dailypulse.sources.presentation.SourcesViewModel
import org.koin.dsl.module

val sourcesModule = module {

    single<SourcesService> {
        SourcesService(get())
    }

    single<SourcesUseCase> {
        SourcesUseCase(get())
    }

    single<SourcesViewModel> {
        SourcesViewModel(get())
    }

    single<SourcesDataSource> {
        SourcesDataSource(get())
    }

    single<SourcesRepository> {
        SourcesRepository(get(), get())
    }
}