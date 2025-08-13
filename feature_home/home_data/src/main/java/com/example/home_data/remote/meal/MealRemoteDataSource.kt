package com.example.home_data.remote.meal

import com.example.core_network.model.Meal

interface MealRemoteDataSource {
    suspend fun getMeals(category: String): List<Meal>
}