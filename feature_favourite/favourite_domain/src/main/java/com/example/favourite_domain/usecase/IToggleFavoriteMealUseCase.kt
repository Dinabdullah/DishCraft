package com.example.favourite_domain.usecase


interface IToggleFavoriteMealUseCase {
    suspend operator fun invoke(mealId: String, isFavorite: Boolean)
}