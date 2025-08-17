package com.example.details_ui

import com.example.details_domain.DetailsDomainModel

sealed class States {
    data object IsLoading : States()
    data object IsOffline : States()
    data class MealFetched(val details: DetailsDomainModel) : States()
}

sealed class Events {
    data class FetchMeal(val id: String) : Events()
    data class OnYoutubeClick(val url: String) : Events()
}

sealed class UiEffect {
    data class OpenYoutube(val url: String) : UiEffect()
}
