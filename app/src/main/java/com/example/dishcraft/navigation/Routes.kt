package com.example.dishcraft.navigation

import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    data object Home : Routes()

    @Serializable
    data class DetailsScreen(val id: String) : Routes()

//    @Serializable
//    data object FavouritesScreen : Routes()
//
    @Serializable
    data object LoginScreen : Routes()

    @Serializable
    data object SignupScreen : Routes()

}