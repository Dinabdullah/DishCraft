package com.example.details_data.di

import com.example.details_data.repository.GetDetailsRepositoryImpl
import com.example.details_domain.repository.GetDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DetailsRepositoryModule {

    @Binds
    @Singleton // Add this annotation
    abstract fun bindGetDetailsRepository( // Make the method name more descriptive
        impl: GetDetailsRepositoryImpl
    ): GetDetailsRepository
}