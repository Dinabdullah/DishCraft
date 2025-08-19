package com.example.auth_data.remote

import com.example.auth_domain.model.UserDomainModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthRemoteDataSource {

    override suspend fun login(email: String, password: String): Result<UserDomainModel> {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            val user = result.user?.let {
                UserDomainModel(
                    uid = it.uid,
                    email = it.email ?: ""
                )
            }
            if (user != null) Result.success(user) else Result.failure(Exception("User not found"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun register(email: String, password: String): Result<UserDomainModel> {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            val user = result.user?.let {
                UserDomainModel(
                    uid = it.uid,
                    email = it.email ?: ""
                )
            }
            if (user != null) Result.success(user) else Result.failure(Exception("User not found"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun logout(): Result<Unit> {
        return try {
            auth.signOut()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun getCurrentUser(): UserDomainModel? {
        return auth.currentUser?.let {
            UserDomainModel(
                uid = it.uid,
                email = it.email ?: ""
            )
        }
    }
}
