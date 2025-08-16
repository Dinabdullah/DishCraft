package com.example.home_data.remote.meal

import com.example.core_network.api.MealApi
import com.example.home_data.local.meal.MealDao
import com.example.home_data.local.meal.toDomain
import com.example.home_data.local.meal.toEntity
import com.example.home_domain.MealDomainModel
import javax.inject.Inject

class MealRemoteDataSourceImpl @Inject constructor(
    private val api: MealApi,
    private val dao: MealDao
) : MealRemoteDataSource {

    override suspend fun getMeals(category: String): List<MealDomainModel> {
        val cached = dao.getMealsByCategory(category)
        if (cached.isNotEmpty()) return cached.map { it.toDomain() }

        val remote = api.getMeals(category).meals?.filterNotNull() ?: emptyList()
        dao.insertMeals(remote.map { it.toEntity(category) })
        val cachedAfterInsert = dao.getMealsByCategory(category)
        return cachedAfterInsert.map { it.toDomain() }


    }
}