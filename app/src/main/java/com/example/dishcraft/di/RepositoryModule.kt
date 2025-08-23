package com.example.dishcraft.di

import com.example.home_data.remote.category.CategoryRemoteDataSource
import com.example.home_data.remote.meal.MealRemoteDataSource
import com.example.home_data.repository.GetCategoryRepositoryImpl
import com.example.home_data.repository.GetMealsRepositoryImpl
import com.example.home_domain.repository.GetCategoryRepository
import com.example.home_domain.repository.GetMealRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideGetMealRepository(
        mealRemoteDataSource: MealRemoteDataSource
    ): GetMealRepository {
        return GetMealsRepositoryImpl(mealRemoteDataSource)
    }

    @Provides
    @Singleton
    fun provideGetCategoryRepository(
        categoryRemoteDataSource: CategoryRemoteDataSource
    ): GetCategoryRepository {
        return GetCategoryRepositoryImpl(categoryRemoteDataSource)
    }
}
