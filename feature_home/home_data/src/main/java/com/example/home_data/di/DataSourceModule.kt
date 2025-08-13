package com.example.home_data.di

import com.example.core_network.api.MealApi
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
    fun provideMealRemoteDataSource(api: MealApi): MealRemoteDataSource {
        return MealRemoteDataSourceImpl(api)
    }

    @Provides
    @Singleton
    fun provideCategoryRemoteDataSource(api: MealApi): CategoryRemoteDataSource {
        return CategoryRemoteDataSourceImpl(api)
    }
}
