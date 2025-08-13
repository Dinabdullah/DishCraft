package com.example.dishcraft

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dishcraft.ui.theme.DishCraftTheme
import com.example.home_ui.HomeScreen
import com.example.home_ui.HomeScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DishCraftTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                 //AppNavHost()
                    val viewModel: HomeScreenViewModel = hiltViewModel()
                    val state by viewModel.uiState.collectAsState()
                    HomeScreen(
                        state = state,
                        events = viewModel::onEvent
                    )
                }
            }
        }
    }
}




