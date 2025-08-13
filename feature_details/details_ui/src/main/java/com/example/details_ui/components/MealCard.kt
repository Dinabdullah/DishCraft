package com.example.details_ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import com.example.details_domain.DetailsDomainModel

@Composable
fun DetailsCard(
    modifier: Modifier = Modifier,
    imageUrl: String,
    title: String,
    onYoutubeClick: () -> Unit,
) {
    Card(
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.dp_16)),
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.dp_8))
    ) {
        Column {
            Box {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.dp_170))
                        .clip(
                            RoundedCornerShape(
                                topStart = dimensionResource(id = R.dimen.dp_16),
                                topEnd = dimensionResource(id = R.dimen.dp_16)
                            )
                        )
                        .padding(vertical = dimensionResource(id = R.dimen.dp_12)),
                    placeholder = painterResource(id = R.drawable.placeholder),
                )

            }

            Row(
                modifier = Modifier
                    .padding(horizontal = dimensionResource(id = R.dimen.dp_24))
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = title,
                    fontFamily = FontFamily(Font(R.font.league_spartan_variable)),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = dimensionResource(id = R.dimen.sp_24).value.sp,
                    color = Color.Black,
                    lineHeight = dimensionResource(id = R.dimen.sp_26).value.sp
                )
                Image(
                    painter = painterResource(id = R.drawable.youtube_logo),
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.dp_44))
                        .clickable { onYoutubeClick() }
                )
            }
        }
    }
}

@Preview
@Composable
private fun CategoryBoxdpre() {

}