package com.example.favourite_data

import com.example.favourite_domain.FavoriteMealRepository
import com.example.home_data.local.meal.MealDao
import com.example.home_data.local.meal.toDomain
import com.example.home_domain.MealDomainModel
import javax.inject.Inject

class FavoriteMealRepositoryImpl @Inject constructor(
    private val mealDao: MealDao
) : FavoriteMealRepository {
    override suspend fun getFavorites(): List<MealDomainModel> {
        return mealDao.getFavoriteMeals().map { it.toDomain() }
    }

    override suspend fun toggleFavorite(mealId: String, isFavorite: Boolean) {
        mealDao.updateFavorite(mealId, isFavorite)
    }
}