package com.example.auth_ui.di

import android.content.SharedPreferences
import com.example.auth_data.remote.AuthRemoteDataSource
import com.example.auth_data.remote.AuthRemoteDataSourceImpl
import com.example.auth_data.repository.AuthRepositoryImpl
import com.example.auth_domain.repository.AuthRepository
import com.example.auth_domain.usecase.LoginUseCase
import com.example.auth_domain.usecase.RegisterUseCase
import com.example.sharedpreferences.sharedpreferences.UserPreferences
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideUserPreferences(sharedPreferences: SharedPreferences): UserPreferences =
        UserPreferences(sharedPreferences)

    @Provides
    @Singleton
    fun provideAuthRemoteDataSource(auth: FirebaseAuth): AuthRemoteDataSource =
        AuthRemoteDataSourceImpl(auth)

    @Provides
    @Singleton
    fun provideAuthRepository(
        remote: AuthRemoteDataSource,
        userPreferences: UserPreferences
    ): AuthRepository = AuthRepositoryImpl(remote, userPreferences)

    @Provides
    fun provideLoginUseCase(repository: AuthRepository): LoginUseCase =
        LoginUseCase(repository)

    @Provides
    fun provideRegisterUseCase(repository: AuthRepository): RegisterUseCase =
        RegisterUseCase(repository)
}
