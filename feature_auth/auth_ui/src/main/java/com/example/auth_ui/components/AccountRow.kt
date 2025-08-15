package com.example.auth_ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.core_ui.R

@Composable
fun AccountRow(
    labelText: String,
    actionText: String,
    onActionClick: () -> Unit
) {
    Row(modifier = Modifier.clickable { onActionClick() }) {
        Text(
            text = labelText,
            fontSize = dimensionResource(id = com.example.core_ui.R.dimen.sp_20).value.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily(Font(R.font.league_spartan_variable)),

            )
        Text(
            text = actionText,
            color = colorResource(com.example.core_ui.R.color.red_pink_main),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.league_spartan_variable)),
            textDecoration = TextDecoration.Underline,
            fontSize = dimensionResource(id = com.example.core_ui.R.dimen.sp_24).value.sp,
        )
    }
}

@Preview
@Composable
private fun AccountRowPrev() {
    AccountRow(
        labelText = "Don't have an account?",
        actionText = "Sign Up",
        onActionClick = {}
    )
}