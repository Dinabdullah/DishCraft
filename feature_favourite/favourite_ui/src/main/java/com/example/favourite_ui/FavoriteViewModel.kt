package com.example.favourite_ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.favourite_domain.IGetFavoriteMealsUseCase
import com.example.favourite_domain.IToggleFavoriteMealUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getFavoriteMealsUseCase: IGetFavoriteMealsUseCase,
    private val toggleFavoriteMealUseCase: IToggleFavoriteMealUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(States())
    val state: StateFlow<States> = _state

    fun handleIntent(event: Events) {
        when (event) {
            is Events.LoadFavorites -> loadFavorites()
            is Events.ToggleFavorite -> toggleFavorite(event.mealId, event.isFav)
        }
    }

    private fun loadFavorites() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            try {
                val meals = getFavoriteMealsUseCase()
                _state.value = _state.value.copy(
                    isLoading = false,
                    favorites = meals,
                    error = null
                )
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }

    private fun toggleFavorite(mealId: String, isFav: Boolean) {
        viewModelScope.launch {
            toggleFavoriteMealUseCase(mealId, isFav)
            loadFavorites()
        }
    }
}


