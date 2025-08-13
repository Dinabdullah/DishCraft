package com.example.home_domain.usecase.meal

import com.example.home_domain.MealDomainModel

interface IGetMealsUseCase {
    suspend operator fun invoke(category: String): List<MealDomainModel>

}