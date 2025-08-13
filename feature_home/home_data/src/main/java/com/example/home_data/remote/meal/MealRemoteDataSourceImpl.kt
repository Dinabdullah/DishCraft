package com.example.home_data.remote.meal

import com.example.core_network.api.MealApi
import com.example.core_network.model.Meal
import javax.inject.Inject

class MealRemoteDataSourceImpl @Inject constructor(private val api: MealApi) :
    MealRemoteDataSource {
    override suspend fun getMeals(category: String): List<Meal> {
        return api.getMeals(category).meals?.filterNotNull() ?: emptyList()
    }

}