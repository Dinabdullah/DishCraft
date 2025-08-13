package com.example.home_data.remote.category

import com.example.core_network.model.Category

interface CategoryRemoteDataSource {
    suspend fun getCategory(): List<Category>
}