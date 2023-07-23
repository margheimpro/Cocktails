package com.example.cocktails

import android.app.Application
import com.example.cocktails.data.appModule
import com.example.cocktails.ui.viewModels
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CocktailApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CocktailApplication)
            modules(listOf(appModule, viewModels))
        }
    }
}