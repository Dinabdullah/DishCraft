package com.example.auth_ui.signup

import androidx.lifecycle.ViewModel
import com.example.auth_ui.R
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val auth: FirebaseAuth
) : ViewModel() {

    // UI State
    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState

    fun onEvent(event: Events) {
        when (event) {
            is Events.OnEmailChange -> _uiState.value =
                _uiState.value.copy(email = event.email, error = null)

            is Events.OnPasswordChange -> _uiState.value =
                _uiState.value.copy(password = event.password, error = null)

            is Events.OnConfirmPasswordChange -> _uiState.value =
                _uiState.value.copy(confirmPassword = event.confirmPassword, error = null)

            Events.OnSignUpClicked -> signUp()
        }
    }

    private fun signUp() {
        val email = _uiState.value.email.trim()
        val password = _uiState.value.password.trim()
        val confirmPassword = _uiState.value.confirmPassword.trim()

        if (email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
            _uiState.value = _uiState.value.copy(error = R.string.please_fill_in_all_fields)
            return
        }

        if (password != confirmPassword) {
            _uiState.value = _uiState.value.copy(error = R.string.passwords_do_not_match)
            return
        }

        _uiState.value = _uiState.value.copy(isLoading = true, error = null)

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        isSuccess = true,
                        error = null
                    )
                } else {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = R.string.authentication_failed
                    )
                }
            }
    }

}
