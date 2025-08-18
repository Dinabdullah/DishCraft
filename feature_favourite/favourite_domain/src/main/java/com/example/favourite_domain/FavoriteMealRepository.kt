package com.example.favourite_domain

import com.example.home_domain.MealDomainModel

interface FavoriteMealRepository {
    suspend fun getFavorites(): List<MealDomainModel>
    suspend fun toggleFavorite(mealId: String, isFavorite: Boolean)
}