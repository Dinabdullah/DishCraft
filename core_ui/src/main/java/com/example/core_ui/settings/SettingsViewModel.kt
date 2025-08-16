package com.example.core_ui.settings

import androidx.lifecycle.ViewModel
import com.example.sharedpreferences.sharedpreferences.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val userPreferences: UserPreferences
): ViewModel() {

    fun logout() {
        userPreferences.clearLoginInfo()
    }
}
