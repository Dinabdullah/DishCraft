package com.example.home_data.mapper

import com.example.core_network.model.Category
import com.example.home_domain.CategoryDomainModel


fun Category.toDomain(): CategoryDomainModel {
    return CategoryDomainModel(
        id = idCategory,
        name = strCategory,
        description = strCategoryDescription,
        thumbnail = strCategoryThumb
    )
}
