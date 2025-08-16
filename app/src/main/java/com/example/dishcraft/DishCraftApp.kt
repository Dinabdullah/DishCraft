package com.example.dishcraft

import android.app.Application
import android.content.Context
import com.example.core_ui.LocaleManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DishCraftApp : Application() {
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleManager.setLocale(base, LocaleManager.getLocale(base)))
    }
}