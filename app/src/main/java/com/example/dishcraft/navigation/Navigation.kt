//package com.example.dishcraft.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import androidx.navigation.toRoute
//import com.example.details_ui.DetailsScreen
//import com.example.details_ui.Events
//import com.example.home_ui.HomeScreen
//import com.example.home_ui.HomeScreenViewModel
//
//@Composable
//fun AppNavHost() {
//    val navController = rememberNavController()
//
//    NavHost(
//        navController = navController,
//        startDestination = Routes.Home
//    ) {
//        composable<Routes.Home> {
//            val viewModel: HomeScreenViewModel = hiltViewModel()
//            val state by viewModel.uiState.collectAsState()
//            HomeScreen(
//                state = state,
//                events = viewModel::onEvent
//            )
//        }
////        composable<Routes.DetailsScreen> { backStackEntry ->
////            val details = backStackEntry.toRoute<Routes.DetailsScreen>()
////            val viewModel: DetailsScreenViewModel = hiltViewModel()
////            val state by viewModel.uiState.collectAsState()
////
////            LaunchedEffect(Unit) {
////                viewModel.onEvent(Events.FetchMeal(details.id))
////            }
////            DetailsScreen(
////                states = state,
////                events = viewModel::onEvent,
////            )
////
////        }
//    }
//}
