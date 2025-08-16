package com.example.auth_ui.login

import androidx.lifecycle.ViewModel
import com.example.auth_ui.R
import com.example.sharedpreferences.sharedpreferences.UserPreferences
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val auth: FirebaseAuth,
    private val userPreferences: UserPreferences
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEvent(event: Events) {
        when (event) {
            is Events.OnEmailChange -> {
                _uiState.value = _uiState.value.copy(email = event.email)
            }

            is Events.OnPasswordChange -> {
                _uiState.value = _uiState.value.copy(password = event.password)
            }

            Events.OnLoginClicked -> {
                login()
            }
        }
    }
    private fun login() {
        val email = _uiState.value.email
        val password = _uiState.value.password

        if (email.isBlank() || password.isBlank()) {
            _uiState.value = _uiState.value.copy(error = R.string.please_fill_in_all_fields)
            return
        }

        _uiState.value = _uiState.value.copy(isLoading = true, error = null)

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                _uiState.value = if (task.isSuccessful) {
                    userPreferences.saveLoginInfo(email,password)
                    _uiState.value.copy(isLoading = false, isSuccess = true, error = null)
                } else {
                    _uiState.value.copy(isLoading = false, error = R.string.authentication_failed)
                }
            }
    }
}