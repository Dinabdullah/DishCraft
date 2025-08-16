package com.example.home_data.remote.meal

import com.example.home_domain.MealDomainModel

interface MealRemoteDataSource {
    suspend fun getMeals(category: String): List<MealDomainModel>
}