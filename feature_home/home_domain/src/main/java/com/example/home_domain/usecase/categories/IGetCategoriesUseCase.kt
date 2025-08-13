package com.example.home_domain.usecase.categories

import com.example.home_domain.CategoryDomainModel

interface IGetCategoriesUseCase {
    suspend operator fun invoke(): List<CategoryDomainModel>
}