package com.abdul.dev.dailypulse.android.di

import abdul.dev.dailypulse.db.DailyPulseDatabase
import app.cash.sqldelight.db.SqlDriver
import com.abdul.dev.dailypulse.db.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> {
        DatabaseDriverFactory(androidContext()).createDriver()
    }

    single<DailyPulseDatabase> {
        DailyPulseDatabase(get())
    }
}