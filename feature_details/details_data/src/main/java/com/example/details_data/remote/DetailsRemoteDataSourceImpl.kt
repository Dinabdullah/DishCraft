package com.example.details_data.remote

import com.example.core_network.api.MealApi
import com.example.core_network.model.MealX
import javax.inject.Inject

class DetailsRemoteDataSourceImpl @Inject constructor(private val mealApi: MealApi) :
    DetailsRemoteDataSource {
    override suspend fun getDetails(id: String): MealX {
        return mealApi.getMealDetails(id).meals?.get(0) ?: throw Exception("Meal not found")

    }
}