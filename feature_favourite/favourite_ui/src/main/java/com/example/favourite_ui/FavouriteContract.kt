package com.example.favourite_ui

import com.example.home_domain.MealDomainModel

sealed class EventsFav {
    data object LoadFavorites : EventsFav()
    data class ToggleFavorite(val mealId: String, val isFav: Boolean) : EventsFav()
}

data class StatesFav(
    val isLoading: Boolean = false,
    val favorites: List<MealDomainModel> = emptyList(),
    val error: String? = null
)

