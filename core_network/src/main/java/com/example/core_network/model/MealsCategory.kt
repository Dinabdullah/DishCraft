package com.example.core_network.model


import com.google.gson.annotations.SerializedName

data class MealsCategory(
    @SerializedName("categories")
    val categories: List<Category?>?
)