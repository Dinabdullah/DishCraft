package com.example.auth_data.repository


import com.example.auth_data.remote.AuthRemoteDataSource
import com.example.auth_domain.model.UserDomainModel
import com.example.auth_domain.repository.AuthRepository
import com.example.sharedpreferences.sharedpreferences.UserPreferences
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val remote: AuthRemoteDataSource,
    private val userPreferences: UserPreferences
) : AuthRepository {

    override suspend fun login(email: String, password: String): Result<UserDomainModel> {
        val result = remote.login(email, password)
        if (result.isSuccess) {
            userPreferences.saveLoginInfo(email, password)
        }
        return result
    }

    override suspend fun register(email: String, password: String): Result<UserDomainModel> {
        val result = remote.register(email, password)
        if (result.isSuccess) {
            userPreferences.saveLoginInfo(email, password)
        }
        return result
    }

    override suspend fun logout(): Result<Unit> {
        return remote.logout()
    }

    override fun getCurrentUser(): UserDomainModel? {
        return remote.getCurrentUser()
    }
}
