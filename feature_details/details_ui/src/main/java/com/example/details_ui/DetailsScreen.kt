package com.example.details_ui

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.core_ui.R
import com.example.core_ui.component.NoInternet
import com.example.details_ui.components.DetailsCard
import com.example.details_ui.components.InfoItem
import com.example.details_ui.utills.openYoutubeLink

@OptIn(ExperimentalMaterial3Api::class, ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.DetailsScreen(
    modifier: Modifier = Modifier,
    states: States,
    events: (Events) -> Unit,
    id: String,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(com.example.details_ui.R.string.meal_details),
                        fontFamily = FontFamily(
                            Font(R.font.league_spartan_variable)
                        ),
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    titleContentColor = colorResource(id = R.color.red_pink_main)
                )
            )
        },
    ) { paddings ->
        when (states) {
            States.IsLoading -> {
                Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            States.IsOffline -> {
                NoInternet(onRetry = {
                    events(
                        Events.FetchMeal(id)
                    )
                })
            }

            is States.MealFetched -> {
                val context = LocalContext.current
                LazyColumn(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(horizontal = dimensionResource(id = R.dimen.dp_12))
                        .padding(paddings),
                ) {
                    // Card
                    item {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            DetailsCard(
                                imageUrl = states.details.thumbnail ?: "",
                                title = states.details.name ?: "",
                                onYoutubeClick = {
                                    states.details.youtube?.let { url ->
                                       context.openYoutubeLink(url)
                                    }
                                },
                                animatedVisibilityScope = animatedVisibilityScope,
                                mealId = states.details.id ?: ""

                            )
                        }
                    }

                    // Category
                    item {
                        InfoItem(label = "Category", value = states.details.category)
                    }

                    // Area
                    item {
                        InfoItem(label = "Area", value = states.details.area)
                    }

                    // Instructions
                    item {
                        InfoItem(label = "Instructions", value = states.details.instructions)
                    }

                    // Ingredients + Measures
                    item {
                        Column(modifier = Modifier.padding(dimensionResource(id = R.dimen.dp_16))) {
                            Text(
                                text = "Ingredients",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = dimensionResource(id = R.dimen.dp_24).value.sp,
                                fontFamily = FontFamily(
                                    Font(R.font.league_spartan_variable)
                                ),
                            )
                            states.details.ingredients.zip(states.details.measures)
                                .forEach { (ingredient, measure) ->
                                    if (!ingredient.isNullOrEmpty()) {
                                        Text(
                                            text = "$ingredient - $measure",
                                            fontWeight = FontWeight.SemiBold,
                                            color = Color.Gray,
                                            fontFamily = FontFamily(
                                                Font(R.font.league_spartan_variable)
                                            ),
                                        )
                                    }
                                }
                        }
                    }
                }
            }
        }

    }
}


//@Preview
//@Composable
//private fun DetailsScreenPreview() {
//    DetailsScreen(
//        details = DetailsDomainModel(
//            id = "1",
//            name = "Meal Name",
//            thumbnail = "https://www.themealdb.com/images/media/meals/15487",
//            category = "Category",
//            area = "Area",
//            instructions = "Instructions",
//            youtube = "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
//            strSource = "https://www.source.com",
//            ingredients = listOf("Ingredient 1", "Ingredient 2", "Ingredient 3"),
//            measures = listOf("Measure 1", "Measure 2", "Measure 3")
//        ),
//
//    )
//}
