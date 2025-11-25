package com.example.favourite_ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.favourite_domain.usecase.IGetFavoriteMealsUseCase
import com.example.favourite_domain.usecase.IToggleFavoriteMealUseCase
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

    private val _state = MutableStateFlow(StatesFav())
    val state: StateFlow<StatesFav> = _state

    fun handleIntent(event: EventsFav) {
        when (event) {
            is EventsFav.LoadFavorites -> loadFavorites()
            is EventsFav.ToggleFavorite -> toggleFavorite(event.mealId, event.isFav)
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
        val currentState = _state.value
        val updatedFavorites = if (isFav) {
            currentState.favorites
        } else {
            currentState.favorites.filter { it.id != mealId }
        }

        _state.value = currentState.copy(favorites = updatedFavorites)
        viewModelScope.launch {
            try {
                toggleFavoriteMealUseCase(mealId, isFav)
                loadFavorites()
            } catch (e: Exception) {
                _state.value = currentState
                _state.value = _state.value.copy(error = e.message)
            }
        }
    }
}


