package com.example.favourite_domain


import javax.inject.Inject

class ToggleFavoriteMealUseCaseImpl @Inject constructor(
    private val favoriteMealRepository: FavoriteMealRepository
) : IToggleFavoriteMealUseCase {
    override suspend fun invoke(mealId: String, isFavorite: Boolean) {
        favoriteMealRepository.toggleFavorite(mealId, isFavorite)
    }
}