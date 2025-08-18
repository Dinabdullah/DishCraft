package com.example.home_data.local.meal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MealDao {
    @Query("SELECT * FROM meals WHERE category = :category")
    suspend fun getMealsByCategory(category: String): List<MealEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeals(meals: List<MealEntity>)

    @Query("DELETE FROM meals WHERE category = :category")
    suspend fun deleteMealsByCategory(category: String)

    // ✨ جديدة: تجيب كل الفيفوريت
    @Query("SELECT * FROM meals WHERE isFavorite = 1")
    suspend fun getFavoriteMeals(): List<MealEntity>

    // ✨ جديدة: تحدث حالة الفيفوريت
    @Query("UPDATE meals SET isFavorite = :isFav WHERE id = :mealId")
    suspend fun updateFavorite(mealId: String, isFav: Boolean)

}