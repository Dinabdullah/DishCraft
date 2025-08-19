package com.example.auth_domain.repository

import com.example.auth_domain.model.UserDomainModel

interface AuthRepository {
    suspend fun login(email: String, password: String): Result<UserDomainModel>
    suspend fun register(email: String, password: String): Result<UserDomainModel>
    suspend fun logout(): Result<Unit>
    fun getCurrentUser(): UserDomainModel?
}
