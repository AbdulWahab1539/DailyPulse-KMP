package com.abdul.dev.dailypulse.di

import abdul.dev.dailypulse.db.DailyPulseDatabase
import app.cash.sqldelight.db.SqlDriver
import com.abdul.dev.dailypulse.db.DatabaseDriverFactory
import org.koin.dsl.module


val databaseModule = module {
    single<SqlDriver> {
        DatabaseDriverFactory().createDriver()
    }

    single<DailyPulseDatabase> {
        DailyPulseDatabase(get())
    }
}