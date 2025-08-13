package com.example.core_network.api

import com.example.core_network.model.MealsCategory
import com.example.core_network.model.MealsDetails
import com.example.core_network.model.MealsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {

    @GET("categories.php")
    suspend fun getCategories(): MealsCategory

    @GET("filter.php")
    suspend fun getMeals(
        @Query("c") category: String
    ): MealsResponse

    @GET("lookup.php")
    suspend fun getMealDetails(
        @Query("i") id: String
    ): MealsDetails

}