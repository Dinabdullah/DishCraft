package com.example.core_ui.splashscreen

import androidx.lifecycle.ViewModel
import com.example.sharedpreferences.sharedpreferences.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val userPreferences: UserPreferences
) : ViewModel() {
    fun isLoggedIn(): Boolean {
        return userPreferences.isLoggedIn()
    }

    fun isFirstTime(): Boolean = userPreferences.isFirstTime()

    fun setNotFirstTime() {
        userPreferences.setFirstTime(false)
    }

}





