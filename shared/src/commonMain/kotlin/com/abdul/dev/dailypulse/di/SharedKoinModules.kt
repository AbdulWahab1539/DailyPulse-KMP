package com.abdul.dev.dailypulse.di

import com.abdul.dev.dailypulse.articles.di.articlesModule

val sharedKoinModules = listOf(
    articlesModule,
    networkModule
)