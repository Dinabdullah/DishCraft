package com.example.favourite_domain


interface IToggleFavoriteMealUseCase {
    suspend operator fun invoke(mealId: String, isFavorite: Boolean)
}