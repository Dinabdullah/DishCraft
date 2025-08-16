package com.example.dishcraft

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.dishcraft.navigation.AppNavHost
import com.example.dishcraft.ui.theme.DishCraftTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DishCraftTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    AppNavHost()
                }
            }
        }
    }
}




