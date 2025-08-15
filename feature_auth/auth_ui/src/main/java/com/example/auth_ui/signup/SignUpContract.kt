package com.example.auth_ui.signup

data class SignUpUiState(
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val error: Int? = null
)

sealed class Events {
    data class OnEmailChange(val email: String) : Events()
    data class OnPasswordChange(val password: String) : Events()
    data class OnConfirmPasswordChange(val confirmPassword: String) : Events()
    data object OnSignUpClicked : Events()
}