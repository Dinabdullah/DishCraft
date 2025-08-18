package com.example.favourite_data.di

import com.example.favourite_data.FavoriteMealRepositoryImpl
import com.example.favourite_domain.FavoriteMealRepository
import com.example.favourite_domain.GetFavoriteMealsUseCaseImpl
import com.example.favourite_domain.IGetFavoriteMealsUseCase
import com.example.favourite_domain.IToggleFavoriteMealUseCase
import com.example.favourite_domain.ToggleFavoriteMealUseCaseImpl
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