package com.example.dishcraft.navigation

import android.util.Log
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.auth_ui.login.LoginScreen
import com.example.auth_ui.login.LoginViewModel
import com.example.auth_ui.signup.SignUpScreen
import com.example.auth_ui.signup.SignUpViewModel
import com.example.core_ui.onboarding.OnboardingComponent
import com.example.core_ui.onboarding.OnboardingScreenHorizontal
import com.example.details_ui.DetailsScreen
import com.example.details_ui.DetailsScreenViewModel
import com.example.details_ui.Events
import com.example.dishcraft.splashscreen.SplashScreen
import com.example.favourite_ui.Events
import com.example.favourite_ui.FavoriteScreen
import com.example.favourite_ui.FavoriteViewModel
import com.example.feature_settings.ui.SettingScreen
import com.example.feature_settings.ui.SettingsViewModel
import com.example.home_ui.HomeScreen
import com.example.home_ui.HomeScreenViewModel

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    SharedTransitionLayout {
        NavHost(
            navController = navController,
            startDestination = Routes.SplashScreen
        ) {
            composable<Routes.SplashScreen> {
                SplashScreen(
                    onNavigateToHome = {
                        navController.navigate(Routes.Home) {
                            popUpTo(Routes.SplashScreen) { inclusive = true }
                        }
                    },
                    onNavigateToLogin = {
                        navController.navigate(Routes.LoginScreen) {
                            popUpTo(Routes.SplashScreen) { inclusive = true }
                        }
                    },
                    onNavigateToOnboarding = {
                        navController.navigate(Routes.OnboardingScreen) {
                            popUpTo(Routes.SplashScreen) { inclusive = true }
                        }
                    }
                )
            }

            composable<Routes.Home> {
                val viewModel: HomeScreenViewModel = hiltViewModel()
                val state by viewModel.uiState.collectAsState()
                HomeScreen(
                    state = state,
                    events = viewModel::onEvent,
                    onNavigateToDetails = { id ->
                        navController.navigate(Routes.DetailsScreen(id))
                    },
                    onNavigateToSetting = {
                        navController.navigate(Routes.SettingsScreen)
                    },
                    animatedVisibilityScope = this,
                    onToggleFavorite = { mealId, isFav ->
                        viewModel.onEvent(com.example.home_ui.Events.ToggleFavorite(mealId, isFav))
                    },
                    onNavigateToFav ={
                        navController.navigate(Routes.FavouritesScreen)
                    }
                )
            }
            composable<Routes.DetailsScreen> { backStackEntry ->
                val details = backStackEntry.toRoute<Routes.DetailsScreen>()
                val viewModel: DetailsScreenViewModel = hiltViewModel()
                val state by viewModel.uiState.collectAsState()

                LaunchedEffect(Unit) {
                    viewModel.onEvent(Events.FetchMeal(details.id))
                }
                DetailsScreen(
                    states = state,
                    events = viewModel::onEvent,
                    id = details.id,
                    animatedVisibilityScope = this,
                    effects = viewModel.effect
                )

            }
            composable<Routes.LoginScreen> {
                val viewModel: LoginViewModel = hiltViewModel()
                val state by viewModel.uiState.collectAsState()
                LoginScreen(
                    onSignUpClicked = {
                        navController.navigate(Routes.SignupScreen)
                    },
                    states = state,
                    events = viewModel::onEvent,
                    onHomeClicked = {
                        navController.navigate(Routes.Home) {
                            popUpTo(Routes.LoginScreen) {
                                inclusive = false
                            }
                        }
                    }
                )
            }
            composable<Routes.SignupScreen> {
                val viewModel: SignUpViewModel = hiltViewModel()
                val state by viewModel.uiState.collectAsState()
                SignUpScreen(
                    onLoginClicked = {
                        navController.navigate(Routes.LoginScreen)
                    },
                    states = state,
                    events = viewModel::onEvent
                )
            }
            composable<Routes.OnboardingScreen> {
                OnboardingScreenHorizontal(
                    screens = listOf(
                        OnboardingComponent.Screen1,
                        OnboardingComponent.Screen2,
                        OnboardingComponent.Screen3
                    ),
                    onFinish = {
                        navController.navigate(Routes.LoginScreen)
                    }
                )
            }
            composable<Routes.SettingsScreen> {
                val viewModel: SettingsViewModel =hiltViewModel()
               SettingScreen(
                   onLogoutConfirmed = {
                       viewModel.logout()
                       navController.navigate(Routes.LoginScreen) {
                           popUpTo(Routes.Home) { inclusive = true }
                       }
                   },
                   onBack = {
                       navController.popBackStack()
                   }
               )
            }
            composable<Routes.FavouritesScreen> {

                val viewModel: FavoriteViewModel = hiltViewModel()
                val state by viewModel.state.collectAsState()
                LaunchedEffect(Unit) {
                    viewModel.handleIntent(Events.LoadFavorites)
                }
                FavoriteScreen(
                    state = state,
//                    onNavigateToDetails = { id ->
//                        navController.navigate(Routes.DetailsScreen(id))
//                    },
                    onToggleFavorite = { mealId, isFav ->
                        Log.d("HomeScreen", "Toggling favorite for ${mealId} to ${isFav}")
                        viewModel.handleIntent(Events.ToggleFavorite(mealId, isFav))
                    },
                    animatedVisibilityScope = this,
                    onBack = {
                        navController.popBackStack()
                    }
                )

            }


        }
    }
}
