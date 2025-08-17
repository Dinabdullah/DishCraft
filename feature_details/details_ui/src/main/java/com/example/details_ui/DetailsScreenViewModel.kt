package com.example.details_ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.details_domain.usecase.IGetDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
  private val getDetailsUseCase: IGetDetailsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<States>(States.IsLoading)
    val uiState: StateFlow<States> = _uiState

    private val _effect = MutableSharedFlow<UiEffect>()
    val effect = _effect.asSharedFlow()

    fun onEvent(event: Events) {
        when (event) {
            is Events.FetchMeal -> fetchMeal(event.id)
           is Events.OnYoutubeClick -> openYoutubeLink(event.url)
        }
    }

    private fun openYoutubeLink(url: String) {
        viewModelScope.launch {
            _effect.emit(UiEffect.OpenYoutube(url))
        }
    }

    private fun fetchMeal(id: String) {
        viewModelScope.launch {
            _uiState.value = States.IsLoading
            try {
                val details = getDetailsUseCase(id)
                _uiState.value = States.MealFetched(details)
            } catch (e: Exception) {
                _uiState.value = States.IsOffline
            }
        }
    }
}
