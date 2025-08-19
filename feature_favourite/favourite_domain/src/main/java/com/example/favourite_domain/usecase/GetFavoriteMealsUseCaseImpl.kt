package com.example.favourite_domain.usecase

import com.example.favourite_domain.repository.FavoriteMealRepository
import com.example.home_domain.MealDomainModel
import javax.inject.Inject

class GetFavoriteMealsUseCaseImpl @Inject constructor(
    private val favoriteMealRepository: FavoriteMealRepository
) : IGetFavoriteMealsUseCase {
    override suspend fun invoke(): List<MealDomainModel> {
        return favoriteMealRepository.getFavorites()
    }
}