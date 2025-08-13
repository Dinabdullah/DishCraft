package com.example.home_domain.usecase.categories

import com.example.home_domain.CategoryDomainModel
import com.example.home_domain.repository.GetCategoryRepository
import javax.inject.Inject

class GetCategoriesUseCaseImpl @Inject constructor(
    private val getCategoriesRepository: GetCategoryRepository
) : IGetCategoriesUseCase {
    override suspend fun invoke(): List<CategoryDomainModel> {
        return getCategoriesRepository.getCategory()
    }
}