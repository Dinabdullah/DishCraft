package com.example.auth_ui.login

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val error: Int? = null
)


sealed class Events {
    data object OnLoginClicked : Events()
    data class OnEmailChange(val email: String) : Events()
    data class OnPasswordChange(val password: String) : Events()

}