package com.example.details_domain.repository

import com.example.details_domain.DetailsDomainModel

interface GetDetailsRepository {
    suspend fun getDetails(id: String): DetailsDomainModel
}
