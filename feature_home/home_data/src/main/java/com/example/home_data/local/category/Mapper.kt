package com.example.home_data.local

import com.example.core_network.model.Category
import com.example.home_domain.CategoryDomainModel

fun Category.toEntity(): CategoryEntity {
   return CategoryEntity(
       id = idCategory?:"",
       name = strCategory?:"",
       thumbnail = strCategoryThumb,
       description = strCategoryDescription

   )
}
fun CategoryEntity.toDomain(): CategoryDomainModel {
    return CategoryDomainModel(
        id = this.id,
        name = this.name,
        thumbnail = this.thumbnail,
        description = this.description
    )
}