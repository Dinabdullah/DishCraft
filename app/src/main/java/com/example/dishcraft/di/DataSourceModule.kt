package com.example.dishcraft.di

import com.example.core_network.api.MealApi
import com.example.home_data.local.category.CategoryDao
import com.example.home_data.local.meal.MealDao
import com.example.home_data.remote.category.CategoryRemoteDataSource
import com.example.home_data.remote.category.CategoryRemoteDataSourceImpl
import com.example.home_data.remote.meal.MealRemoteDataSource
import com.example.home_data.remote.meal.MealRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideMealRemoteDataSource(api: MealApi,dao: MealDao): MealRemoteDataSource {
        return MealRemoteDataSourceImpl(api,dao)
    }

    @Provides
    @Singleton
    fun provideCategoryRemoteDataSource(api: MealApi,dao: CategoryDao): CategoryRemoteDataSource {
        return CategoryRemoteDataSourceImpl(api,dao)
    }
}
