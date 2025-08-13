package com.example.details_data.mapper

import com.example.core_network.model.MealX
import com.example.details_domain.DetailsDomainModel

fun MealX.toDomain(): DetailsDomainModel {
    // نجمع المكونات في ليستة
    val ingredients = listOf(
        strIngredient1, strIngredient2, strIngredient3, strIngredient4, strIngredient5,
        strIngredient6, strIngredient7, strIngredient8, strIngredient9, strIngredient10,
        strIngredient11, strIngredient12, strIngredient13, strIngredient14, strIngredient15,
        strIngredient16?.toString(), strIngredient17?.toString(), strIngredient18?.toString(),
        strIngredient19?.toString(), strIngredient20?.toString()
    ).filterNotNull().filter { it.isNotBlank() }

    // نجمع القياسات في ليستة
    val measures = listOf(
        strMeasure1, strMeasure2, strMeasure3, strMeasure4, strMeasure5,
        strMeasure6, strMeasure7, strMeasure8, strMeasure9, strMeasure10,
        strMeasure11, strMeasure12, strMeasure13, strMeasure14, strMeasure15,
        strMeasure16?.toString(), strMeasure17?.toString(), strMeasure18?.toString(),
        strMeasure19?.toString(), strMeasure20?.toString()
    ).filterNotNull().filter { it.isNotBlank() }

    return DetailsDomainModel(
        id = idMeal,
        name = strMeal,
        thumbnail = strMealThumb,
        category = strCategory,
        area = strArea,
        instructions = strInstructions,
        youtube = strYoutube,
        strSource = strSource?.toString(),
        ingredients = ingredients,
        measures = measures
    )
}
