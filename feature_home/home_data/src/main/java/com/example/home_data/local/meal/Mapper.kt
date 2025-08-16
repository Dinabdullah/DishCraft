package com.example.home_data.local.meal

import com.example.core_network.model.Meal
import com.example.home_domain.MealDomainModel

fun Meal.toEntity(category: String): MealEntity {
    return MealEntity(
        id = idMeal ?: "",
        name = strMeal ?: "",
        thumbnail = strMealThumb,
        category = category
    )

}


fun MealEntity.toDomain(): MealDomainModel {
    return MealDomainModel(
        id = this.id,
        name = this.name,
        thumbnail = this.thumbnail
    )

}