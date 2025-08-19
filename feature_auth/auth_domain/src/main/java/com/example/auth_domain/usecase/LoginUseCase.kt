package com.example.auth_domain.usecase

import com.example.auth_domain.model.UserDomainModel
import com.example.auth_domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): Result<UserDomainModel> {
        return repository.login(email, password)
    }
}
