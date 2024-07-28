package com.abdul.dev.dailypulse.di

import com.abdul.dev.dailypulse.articles.di.articlesModule
import com.abdul.dev.dailypulse.sources.di.sourcesModule

val sharedKoinModules = listOf(
    articlesModule,
    sourcesModule,
    networkModule
)