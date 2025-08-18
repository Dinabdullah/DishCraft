package com.example.home_ui

import com.example.home_domain.CategoryDomainModel
import com.example.home_domain.MealDomainModel

sealed class States {
    data object IsLoading : States()
    data object IsOffline : States()

    data class MealFetched(val list: List<MealDomainModel>) : States()
    data class HomeContent(
        val categories: List<CategoryDomainModel> = emptyList(),
        val selectedCategoryName: String? = null,
        val meals: List<MealDomainModel> = emptyList(),
        val isLoading: Boolean = false,
        val isOffline: Boolean = false
    ) : States()

}

sealed class Events {
    data object FetchCategories : Events()
    data class FetchMeals(val categoryName: String) : Events()
    data class ToggleFavorite(val mealId: String, val isFavorite: Boolean) : Events()

}