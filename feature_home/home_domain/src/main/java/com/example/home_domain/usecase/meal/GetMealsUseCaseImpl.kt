package com.example.home_domain.usecase.meal

import com.example.home_domain.MealDomainModel
import com.example.home_domain.repository.GetMealRepository
import javax.inject.Inject

class GetMealsUseCaseImpl @Inject constructor(
    private val getMealRepository: GetMealRepository
) :
    IGetMealsUseCase {
    override suspend fun invoke(category: String): List<MealDomainModel> {
        return getMealRepository.getMeals(category)
    }
}