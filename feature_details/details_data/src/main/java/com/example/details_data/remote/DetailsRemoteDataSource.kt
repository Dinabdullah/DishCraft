package com.example.details_data.remote

import com.example.core_network.model.MealX

interface DetailsRemoteDataSource {
    suspend fun getDetails(id: String):MealX
}