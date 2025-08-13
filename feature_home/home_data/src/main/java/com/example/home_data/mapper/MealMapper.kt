package com.example.home_data.mapper

import com.example.core_network.model.Meal
import com.example.home_domain.MealDomainModel

fun Meal.toDomain(): MealDomainModel {
    return MealDomainModel(
        id = idMeal,
        name = strMeal,
        thumbnail = strMealThumb
    )
}