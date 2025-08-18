package com.example.home_data.local.meal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meals")
data class MealEntity(
    @PrimaryKey val id: String,
    val name: String,
    val thumbnail: String?,
    val category: String,
    val isFavorite: Boolean = false
)