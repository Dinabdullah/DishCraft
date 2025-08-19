package com.example.auth_ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auth_domain.usecase.RegisterUseCase
import com.example.auth_ui.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

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

        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)

            val result = registerUseCase(email, password)

            _uiState.value = result.fold(
                onSuccess = {
                    _uiState.value.copy(isLoading = false, isSuccess = true)
                },
                onFailure = {
                    _uiState.value.copy(isLoading = false, error = R.string.authentication_failed)
                }
            )
        }
    }
}

