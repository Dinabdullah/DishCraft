package com.example.home_domain.repository

import com.example.home_domain.CategoryDomainModel

interface GetCategoryRepository {
    suspend fun getCategory(): List<CategoryDomainModel>
}