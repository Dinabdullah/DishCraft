package com.example.auth_domain.usecase

import com.example.auth_domain.model.UserDomainModel
import com.example.auth_domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUserUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke(): UserDomainModel? {
        return repository.getCurrentUser()
    }
}
