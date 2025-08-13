package com.example.details_data.repository

import com.example.details_data.mapper.toDomain
import com.example.details_data.remote.DetailsRemoteDataSource
import com.example.details_domain.DetailsDomainModel
import com.example.details_domain.repository.GetDetailsRepository
import javax.inject.Inject

//@Singleton // Add this annotation
class GetDetailsRepositoryImpl @Inject constructor(
    private val detailsRemoteDataSource: DetailsRemoteDataSource
) : GetDetailsRepository {
    override suspend fun getDetails(id: String): DetailsDomainModel {
        return detailsRemoteDataSource.getDetails(id).toDomain()
    }
}