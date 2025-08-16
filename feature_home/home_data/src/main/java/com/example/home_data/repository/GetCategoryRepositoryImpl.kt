package com.example.home_data.repository

import com.example.home_data.mapper.toDomain
import com.example.home_data.remote.category.CategoryRemoteDataSource
import com.example.home_domain.CategoryDomainModel
import com.example.home_domain.repository.GetCategoryRepository
import javax.inject.Inject

class GetCategoryRepositoryImpl @Inject constructor(
    private val mealApi: CategoryRemoteDataSource
) : GetCategoryRepository {
    override suspend fun getCategory(): List<CategoryDomainModel> {
        return mealApi.getCategory()
    }
}

