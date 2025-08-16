package com.example.home_domain

data class MealDomainModel(
    val id: String?,
    val name: String?,
    val thumbnail: String?,
    val categoryId: String? = null,
    val isFavorite: Boolean = false
)
