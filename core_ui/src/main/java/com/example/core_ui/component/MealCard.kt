package com.example.core_ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.core_ui.R

@Composable
fun MealCard(
    modifier: Modifier = Modifier,
    imageUrl: String,
    title: String,
    isFavorite: Boolean,
    onCardClick: () -> Unit,
    onFavoriteClick: () -> Unit,
) {
    Card(
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.dp_16)),
        modifier = Modifier
            .width(dimensionResource(id = R.dimen.dp_200))
            .height(dimensionResource(id = R.dimen.dp_220))
            .padding(dimensionResource(id = R.dimen.dp_8))
            .clickable { onCardClick() }
    ) {
        Column {
            Box {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.dp_170))
                        .clip(
                            RoundedCornerShape(
                                topStart = dimensionResource(id = R.dimen.dp_16),
                                topEnd = dimensionResource(id = R.dimen.dp_16)
                            )
                        ),
                    placeholder = painterResource(id = R.drawable.placeholder),
                )

                IconButton(
                    onClick = onFavoriteClick,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(dimensionResource(id = R.dimen.dp_8))
                        .background(colorResource(id = R.color.red_pink_main), CircleShape)
                        .size(dimensionResource(id = R.dimen.dp_32))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.heart),
                        contentDescription = "Favorite",
                        tint = Color.White,
                        modifier = Modifier.size(dimensionResource(id = R.dimen.dp_24))
                    )
                }
            }

            Column(modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.dp_12))) {
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dp_4)))
                Text(
                    text = title,
                    fontFamily = FontFamily(Font(R.font.league_spartan_variable)),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = dimensionResource(id = R.dimen.sp_26).value.sp
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dp_4)))
            }
        }
    }
}


@Preview
@Composable
private fun CategoryBoxdpre() {
    MealCard(
        imageUrl = R.drawable.meat.toString(),
        title = "Pasta",
        isFavorite = false,
        onCardClick = {},
        onFavoriteClick = {}
    )
}