package com.example.details_domain.usecase

import com.example.details_domain.DetailsDomainModel

interface IGetDetailsUseCase {
    suspend operator fun invoke(id: String):DetailsDomainModel

}