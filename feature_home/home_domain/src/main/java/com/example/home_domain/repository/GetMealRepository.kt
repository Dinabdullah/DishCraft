package com.example.home_domain.repository

import com.example.home_domain.MealDomainModel

interface GetMealRepository {
    suspend fun getMeals(category: String): List<MealDomainModel>
}