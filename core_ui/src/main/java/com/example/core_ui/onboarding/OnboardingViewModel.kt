package com.example.core_ui.onboarding

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OnboardingViewModel : ViewModel() {
    private val _currentPage = MutableStateFlow(0)
    val currentPage: StateFlow<Int> = _currentPage

    fun onNext(totalPages: Int) {
        if (_currentPage.value < totalPages - 1) {
            _currentPage.value += 1
        }
    }

    fun onSkip(totalPages: Int) {
        _currentPage.value = totalPages - 1
    }
}
