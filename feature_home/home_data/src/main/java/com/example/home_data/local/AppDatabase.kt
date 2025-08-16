package com.example.home_data.local


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.home_data.local.meal.MealDao
import com.example.home_data.local.meal.MealEntity


@Database(
    entities = [CategoryEntity::class, MealEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun mealDao(): MealDao

}