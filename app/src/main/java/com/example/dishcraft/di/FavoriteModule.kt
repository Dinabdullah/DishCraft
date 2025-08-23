package com.example.dishcraft.di

import com.example.favourite_data.repository.FavoriteMealRepositoryImpl
import com.example.favourite_domain.repository.FavoriteMealRepository
import com.example.favourite_domain.usecase.GetFavoriteMealsUseCaseImpl
import com.example.favourite_domain.usecase.IGetFavoriteMealsUseCase
import com.example.favourite_domain.usecase.IToggleFavoriteMealUseCase
import com.example.favourite_domain.usecase.ToggleFavoriteMealUseCaseImpl
import com.example.home_data.local.meal.MealDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FavoriteModule {


    @Provides
    @Singleton
    fun provideFavoriteMealRepository(mealDao: MealDao): FavoriteMealRepository {
        return FavoriteMealRepositoryImpl(mealDao)
    }


    @Provides
    @Singleton
    fun provideGetFavoriteMealsUseCase(
        repository: FavoriteMealRepository
    ): IGetFavoriteMealsUseCase {
        return GetFavoriteMealsUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun provideToggleFavoriteMealUseCase(
        repository: FavoriteMealRepository
    ): IToggleFavoriteMealUseCase {
        return ToggleFavoriteMealUseCaseImpl(repository)
    }
}