package com.example.dishcraft.di

import com.example.core_network.api.MealApi
import com.example.details_data.remote.DetailsRemoteDataSource
import com.example.details_data.remote.DetailsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DetailsDataSourceModule {

    @Provides
    @Singleton // Add this annotation
    fun provideMealRemoteDataSource(api: MealApi): DetailsRemoteDataSource {
        return DetailsRemoteDataSourceImpl(api)
    }
}