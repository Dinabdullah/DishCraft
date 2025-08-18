package com.example.favourite_domain

import com.example.home_domain.MealDomainModel

interface IGetFavoriteMealsUseCase {
    suspend operator fun invoke(): List<MealDomainModel>
}