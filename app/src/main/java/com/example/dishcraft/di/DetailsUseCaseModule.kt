package com.example.dishcraft.di

import com.example.details_domain.usecase.GetDetailsUseCaseImpl
import com.example.details_domain.usecase.IGetDetailsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DetailsUseCaseModule {

    @Binds
    abstract fun bindGetDetailsUseCase(
        impl: GetDetailsUseCaseImpl
    ): IGetDetailsUseCase


}