package com.example.core_network.model


import com.google.gson.annotations.SerializedName

data class MealsDetails(
    @SerializedName("meals")
    val meals: List<MealX>?
)