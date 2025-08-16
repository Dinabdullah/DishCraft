package com.example.sharedpreferences.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferenceModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(
        @ApplicationContext app: Context
    ): SharedPreferences {
        return app.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    }
}
