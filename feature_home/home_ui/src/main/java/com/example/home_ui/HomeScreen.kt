package com.example.home_ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.core_ui.component.MealCard
import com.example.core_ui.component.NoInternet
import com.example.home_ui.components.CategoryMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    state: States,
    events: (Events) -> Unit,
    onNavigateToDetails: (String) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.what_are_you_hungry_for_today),
                        fontFamily = FontFamily(
                            Font(com.example.core_ui.R.font.league_spartan_variable)
                        ),
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    titleContentColor = colorResource(id = com.example.core_ui.R.color.red_pink_main)
                )
            )
        },
        bottomBar = {
//            BottomBar(
//                homeClicked = {},
//                searchClicked = {},
//                watchListClicked = {}
//            )
        },
        //containerColor = Color.Black,
    ) {
        when (state) {
            is States.IsLoading -> {
                Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            is States.IsOffline -> {
                NoInternet(onRetry = {
                    events(Events.FetchCategories)
                })
            }

            is States.HomeContent -> {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(it)
                ) {
                    LazyRow(modifier = Modifier.padding(vertical = dimensionResource(id = com.example.core_ui.R.dimen.dp_8))) {
                        items(state.categories.size) { category ->
                            val isSelected =
                                state.categories[category].name == state.selectedCategoryName
                            CategoryMenu(
                                category = state.categories[category],
                                isSelected = isSelected,  // لازم تضيفي هذا في CategoryMenu عشان تبرزي المحدد
                                onCategoryClick = {
                                    if (!isSelected) {
                                        events(
                                            Events.FetchMeals(
                                                state.categories[category].name ?: ""
                                            )
                                        )
                                    }
                                }
                            )
                        }
                    }

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(dimensionResource(id = com.example.core_ui.R.dimen.dp_12)),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(state.meals.size) { meal ->
                            MealCard(
                                imageUrl = state.meals[meal].thumbnail ?: "",
                                title = state.meals[meal].name ?: "",
                                isFavorite = false,
                                onCardClick = { onNavigateToDetails(state.meals[meal].id ?: "") },
                                onFavoriteClick = { /* Handle favorite */ }
                            )
                        }
                    }
                }
            }

            is States.MealFetched -> LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                state = rememberLazyGridState(),
                contentPadding = PaddingValues(dimensionResource(id = com.example.core_ui.R.dimen.dp_12))
            ) {
                items(state.list.size) { index ->
                    val meal = state.list[index]
                    MealCard(
                        modifier = Modifier.padding(it),
                        imageUrl = meal.thumbnail ?: "",
                        title = meal.name ?: "",
                        isFavorite = false,
                        onCardClick = {},
                        onFavoriteClick = {},
                    )
                }
            }
        }

    }
}


@Preview
@Composable
private fun HomeScreenPreview() {
//HomeScreen() { }
}
