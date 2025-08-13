package com.example.home_ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.core_ui.R
import com.example.home_domain.CategoryDomainModel

@Composable
fun CategoryMenu(
    modifier: Modifier = Modifier,
    onCategoryClick: () -> Unit,
    isSelected: Boolean = false,
    category: CategoryDomainModel
) {
    val backgroundColor = if (isSelected) {
        colorResource(id = R.color.red_pink_main)
    } else {
        Color.Transparent
    }
    val textColor = if (isSelected) {
        Color.White
    } else {
        colorResource(id = R.color.red_pink_main)
    }
    Box(
        modifier = modifier
            .padding(
                horizontal = dimensionResource(id = R.dimen.dp_8),
                vertical = dimensionResource(id = R.dimen.dp_8)
            )
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dp_12)))
            .background(backgroundColor)
            .padding(
                horizontal = dimensionResource(id = R.dimen.dp_16),
                vertical = dimensionResource(id = R.dimen.dp_8)
            )
            .clickable { onCategoryClick() }
    ) {
        Text(
            text = category.name ?: "",
            color = textColor,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily(Font(R.font.league_spartan_variable)),
        )
    }
}

@Preview
@Composable
private fun CategoryMenuPreview() {
    CategoryMenu(
        category = CategoryDomainModel(
            id = "1",
            name = "Pizza",
            description = "Delicious beef meals",
            thumbnail = "https://www.themealdb.com/images/category/beef.png"
        ),

        onCategoryClick = {}
    )
}