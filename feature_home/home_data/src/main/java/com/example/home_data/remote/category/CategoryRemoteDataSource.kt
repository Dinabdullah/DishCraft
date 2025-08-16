package com.example.home_data.remote.category

import com.example.core_network.model.Category
import com.example.home_domain.CategoryDomainModel

interface CategoryRemoteDataSource {
    suspend fun getCategory(): List<CategoryDomainModel>
}