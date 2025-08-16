package com.example.auth_ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.core_ui.R

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isLoading: Boolean = false
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.dp_8)),
        modifier = modifier
            .padding(
                vertical = dimensionResource(id = R.dimen.dp_24),
                horizontal = dimensionResource(id = R.dimen.dp_30)
            )
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.dp_49))
    ) {
        if (isLoading) {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(
                    color = Color.White,
                    strokeWidth = dimensionResource(id = R.dimen.dp_2),
                    modifier = Modifier.size(dimensionResource(id = R.dimen.dp_24))
                )
            }
        } else {
            Text(
                text = text,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.league_spartan_variable)),
                fontSize = dimensionResource(id = R.dimen.sp_20).value.sp,
            )
        }
    }
}

@Preview
@Composable
fun CustomButtonPreview(modifier: Modifier = Modifier) {
    CustomButton(
        text = "Login",
        onClick = {},
        isLoading = true,
    )
}