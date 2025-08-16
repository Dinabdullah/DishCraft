package com.example.sharedpreferences.sharedpreferences

import android.content.SharedPreferences
import javax.inject.Inject
import androidx.core.content.edit

class UserPreferences @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {

    companion object {
        private const val KEY_IS_LOGGED_IN = "is_logged_in"
        private const val KEY_EMAIL = "email"
        private const val KEY_IS_FIRST_TIME = "is_first_time"
        private const val KEY_PASSWORD = "password"
    }

    fun saveLoginInfo(email: String, password: String) {
        sharedPreferences.edit {
            putBoolean(KEY_IS_LOGGED_IN, true)
            putString(KEY_EMAIL, email)
            putString(KEY_PASSWORD, password)
        }
    }
    fun setFirstTime(value: Boolean) {
        sharedPreferences.edit { putBoolean(KEY_IS_FIRST_TIME, value) }
    }

    fun clearLoginInfo() {
        sharedPreferences.edit { clear() }
    }

    fun isLoggedIn(): Boolean = sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false)
    fun isFirstTime(): Boolean =
        sharedPreferences.getBoolean(KEY_IS_FIRST_TIME, true)

    fun getEmail(): String? = sharedPreferences.getString(KEY_EMAIL, null)
}
