package com.example.home_ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.favourite_domain.usecase.IToggleFavoriteMealUseCase
import com.example.home_domain.usecase.categories.IGetCategoriesUseCase
import com.example.home_domain.usecase.meal.IGetMealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getCategoriesUseCase: IGetCategoriesUseCase,
    private val getMealsUseCase: IGetMealsUseCase,
    private val toggleFavoriteMealUseCase: IToggleFavoriteMealUseCase

) : ViewModel() {

    private val _uiState = MutableStateFlow(States.HomeContent(isLoading = true))
    val uiState: StateFlow<States.HomeContent> = _uiState

    init {
        fetchCategories()
    }
    fun onResume() {
        val currentCategory = _uiState.value.selectedCategoryName
        if (currentCategory != null) {
            fetchMeals(currentCategory)
        }
    }
    fun onEvent(event: Events) {
        when (event) {
            is Events.FetchCategories -> fetchCategories()
            is Events.FetchMeals -> fetchMeals(event.categoryName)
            is Events.ToggleFavorite -> {
                val currentState = _uiState.value
                val updatedMeals = currentState.meals.map { meal ->
                    if (meal.id == event.mealId) {
                        meal.copy(isFavorite = event.isFavorite)
                    } else meal
                }
                _uiState.value = currentState.copy(meals = updatedMeals)
                //save changes in db
                viewModelScope.launch {
                    toggleFavoriteMealUseCase(event.mealId, event.isFavorite)
                }
            }
            is Events.RefreshCurrentCategory -> {
                val currentCategory = _uiState.value.selectedCategoryName
                if (currentCategory != null) {
                    fetchMeals(currentCategory)
                }
            }


        }
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            _uiState.value = States.HomeContent(isLoading = true)
            try {
                val categories = getCategoriesUseCase()
                Log.d("HomeScreen", "Categories fetched: ${categories.size}")
                Log.d("HomeScreen", "Categories: ${categories.size}")
                val firstCategory = categories.firstOrNull()?.name
                _uiState.value = States.HomeContent(
                    categories = categories,
                    selectedCategoryName = firstCategory,
                    isLoading = false
                )
                // جلب وجبات التصنيف الأول تلقائياً
                firstCategory?.let { fetchMeals(it) }
            } catch (e: Exception) {
                Log.e("HomeScreen", "fetchCategories failed", e)
                _uiState.value = States.HomeContent(isOffline = true)
            }
        }
    }

    private fun fetchMeals(categoryName: String) {
        viewModelScope.launch {
            _uiState.value =
                _uiState.value.copy(isLoading = true, selectedCategoryName = categoryName)
            try {
                val meals = getMealsUseCase(categoryName)
                _uiState.value = _uiState.value.copy(
                    meals = meals,
                    isLoading = false
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(isOffline = true, isLoading = false)
            }
        }
    }
}
