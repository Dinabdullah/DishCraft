package com.example.favourite_ui

import com.example.home_domain.MealDomainModel

sealed class Events {
    data object LoadFavorites : Events()
    data class ToggleFavorite(val mealId: String, val isFav: Boolean) : Events()
}

data class States(
    val isLoading: Boolean = false,
    val favorites: List<MealDomainModel> = emptyList(),
    val error: String? = null
)

