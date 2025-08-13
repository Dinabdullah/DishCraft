package com.example.core_ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.core_ui.R

@Composable
fun NoInternet(
    modifier: Modifier = Modifier,
    onRetry: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        //.padding(dimensionResource(id = R.dimen.dp_12)),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Image(
            painter = painterResource(id = R.drawable.nointernet),
            contentDescription = ""
        )
        Text(
            stringResource(R.string.ooops_no_internet_connection),
            fontSize = dimensionResource(id = R.dimen.sp_20).value.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.league_spartan_variable)),
        )
        Text(
            stringResource(R.string.please_check_your_internet_connection_and_try_again),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.league_spartan_variable)),
            fontSize = dimensionResource(id = R.dimen.sp_15).value.sp,
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.dp_12))
        )
        Button(
            onClick = onRetry,
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.red_pink_main),
                contentColor = Color.White
            )

        ) {
            Text(
                stringResource(R.string.retry),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.league_spartan_variable)),
            )

        }
    }
}


@Preview
@Composable
private fun InternetErrorPrev() {
    NoInternet()
}