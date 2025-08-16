package com.example.home_data.repository

import com.example.home_data.mapper.toDomain
import com.example.home_data.remote.meal.MealRemoteDataSource
import com.example.home_domain.MealDomainModel
import com.example.home_domain.repository.GetMealRepository
import javax.inject.Inject

class GetMealsRepositoryImpl @Inject constructor(private val mealApi: MealRemoteDataSource) :
    GetMealRepository {
    override suspend fun getMeals(category: String): List<MealDomainModel> {
        return mealApi.getMeals(category)
    }
}