package com.example.details_domain.usecase

import com.example.details_domain.DetailsDomainModel
import com.example.details_domain.repository.GetDetailsRepository
import javax.inject.Inject

class GetDetailsUseCaseImpl @Inject constructor(private val getDetailsRepository: GetDetailsRepository) :
    IGetDetailsUseCase {
    override suspend fun invoke(id: String): DetailsDomainModel {
        return getDetailsRepository.getDetails(id)
    }
}