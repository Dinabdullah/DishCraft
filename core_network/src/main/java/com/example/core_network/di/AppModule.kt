package com.example.core_network.di

import com.example.core_network.api.MealApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

    @Provides
    @Singleton
//    fun provideOkHttpClient(): OkHttpClient {
//        return OkHttpClient.Builder()
//            .connectTimeout(30, TimeUnit.SECONDS)  // وقت الاتصال
//            .readTimeout(30, TimeUnit.SECONDS)     // وقت القراءة
//            .build()
//    }
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()


    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideMealApi(retrofit: Retrofit): MealApi {
        return retrofit.create(MealApi::class.java)
    }



}
