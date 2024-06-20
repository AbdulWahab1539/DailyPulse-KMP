package com.abdul.dev.dailypulse.android

import android.app.Application
import com.abdul.dev.dailypulse.android.di.databaseModule
import com.abdul.dev.dailypulse.android.di.viewModelsModules
import com.abdul.dev.dailypulse.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DailyPulseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModules + databaseModule
        startKoin {
            androidContext(this@DailyPulseApp)
            modules(modules)
        }
    }
}