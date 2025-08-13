package com.example.home_domain.di

import com.example.home_domain.usecase.categories.GetCategoriesUseCaseImpl
import com.example.home_domain.usecase.categories.IGetCategoriesUseCase
import com.example.home_domain.usecase.meal.GetMealsUseCaseImpl
import com.example.home_domain.usecase.meal.IGetMealsUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindGetMealsUseCase(
        impl: GetMealsUseCaseImpl
    ): IGetMealsUseCase

    @Binds
    abstract fun bindGetCategoriesUseCase(
        impl: GetCategoriesUseCaseImpl
    ): IGetCategoriesUseCase
}

