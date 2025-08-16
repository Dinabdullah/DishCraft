package com.example.home_data.remote.category

import com.example.core_network.api.MealApi
import com.example.core_network.model.Category
import com.example.home_data.local.CategoryDao
import com.example.home_data.local.toDomain
import com.example.home_data.local.toEntity
import com.example.home_data.mapper.toDomain
import com.example.home_domain.CategoryDomainModel
import javax.inject.Inject

class CategoryRemoteDataSourceImpl @Inject constructor(
    private val api: MealApi,
    private val dao: CategoryDao
) : CategoryRemoteDataSource {
    override suspend fun getCategory(): List<CategoryDomainModel> {
        val cached = dao.getAllCategories()
        if (cached.isNotEmpty()) return cached.map { it.toDomain() }

        return try {
            val remote = api.getCategories().categories?.filterNotNull() ?: emptyList()
            dao.insertCategories(remote.map { it.toEntity() })
            remote.map { it.toDomain() }
        } catch (e: Exception) {
            cached.map { it.toDomain() } // لو حصل خطأ ممكن ترجعي أي بيانات مخزنة
        }
    }
}
