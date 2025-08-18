package com.example.core_ui.onboarding

import com.example.core_ui.R

//data module
sealed class OnboardingComponent(val title: Int, val description: Int, val imageRes: Int) {
    data object Screen1 : OnboardingComponent(
        title = R.string.master,
        description = R.string.the_art_of_cooking,
        imageRes = R.drawable.img1

    )

    data object Screen2 : OnboardingComponent(
        title = R.string.craft,
        description = R.string.your_perfect_dish,
        imageRes = R.drawable.img2
    )

    data object Screen3 : OnboardingComponent(
        title = R.string.from,
        description = R.string.ingredients_to_masterpieces,
        imageRes = R.drawable.img3
    )
}
