package com.example.dishcraft

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.dishcraft.navigation.AppNavHost
import com.example.dishcraft.ui.theme.DishCraftTheme
import com.example.home_ui.LocaleManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleManager.setLocale(base, LocaleManager.getLocale(base)))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        LocaleManager.setLocale(this, LocaleManager.getLocale(this))
        super.onCreate(savedInstanceState)
        setContent {
            DishCraftTheme {
                AppNavHost()
            }
        }
    }
}




