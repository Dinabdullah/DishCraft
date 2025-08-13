package com.example.details_ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.core_ui.R

@Composable
fun InfoItem(label: String, value: String?) {
    if (!value.isNullOrEmpty()) {
        Column(modifier = Modifier.padding( dimensionResource(id = R.dimen.dp_8))) {
            Text(
                text = label,
                fontWeight = FontWeight.ExtraBold,
                fontSize =  dimensionResource(id = R.dimen.dp_24).value.sp,
                fontFamily = FontFamily(
                    Font(R.font.league_spartan_variable)
                ),
            )
            Text(
                text = value,
                fontWeight = FontWeight.SemiBold,
                fontSize =  dimensionResource(id = R.dimen.dp_20).value.sp,
                color = Color.Gray,
                fontFamily = FontFamily(
                    Font(R.font.league_spartan_variable)
                ),
            )
        }
    }
}