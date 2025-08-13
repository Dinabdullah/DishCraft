package com.example.home_data.remote.category

import com.example.core_network.api.MealApi
import com.example.core_network.model.Category
import javax.inject.Inject

class CategoryRemoteDataSourceImpl @Inject constructor(
    private val api: MealApi
) : CategoryRemoteDataSource {
    override suspend fun getCategory(): List<Category> {
        return api.getCategories().categories?.filterNotNull() ?: emptyList()
    }
}