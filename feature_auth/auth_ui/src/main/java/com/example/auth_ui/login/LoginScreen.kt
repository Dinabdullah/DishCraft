package com.example.auth_ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.auth_ui.R
import com.example.auth_ui.components.AccountRow
import com.example.auth_ui.components.CustomButton
import com.example.auth_ui.components.CustomTextField


@Composable
fun LoginScreen(
    states: LoginUiState,
    events: (Events) -> Unit,
    onSignUpClicked: () -> Unit,
    onHomeClicked: () -> Unit
) {

    if (states.isSuccess) {
        onHomeClicked()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.background2),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Text(
            "LOG \n      IN",
            color = Color.Black,
            fontSize = dimensionResource(id = com.example.core_ui.R.dimen.sp_44).value.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily(Font(com.example.core_ui.R.font.league_spartan_variable)),
            lineHeight = dimensionResource(id = com.example.core_ui.R.dimen.sp_44).value.sp,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Gray,
                    offset = Offset(4f, 4f),
                    blurRadius = 8f
                )
            )
        )
        CustomTextField(
            value = states.email,
            onValueChange = { events(Events.OnEmailChange(it)) },
            labelResId = R.string.email,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.email),
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(id = com.example.core_ui.R.dimen.dp_20))
                )
            }
        )

        CustomTextField(
            value = states.password,
            onValueChange = { events(Events.OnPasswordChange(it)) },
            labelResId = R.string.password,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.lock),
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(id = com.example.core_ui.R.dimen.dp_20))
                )
            }
        )

        states.error?.let {
            Text(
                text = stringResource(id = it),
                color = Color.Red,
                fontSize = dimensionResource(id = com.example.core_ui.R.dimen.sp_15).value.sp
            )
        }

        CustomButton(
            text = stringResource(id = R.string.login),
            onClick = { events(Events.OnLoginClicked) },
            isLoading = states.isLoading
        )

        AccountRow(
            labelText = stringResource(R.string.don_t_have_an_account),
            actionText = stringResource(R.string.sign_up),
            onActionClick = onSignUpClicked
        )
    }
}


@Preview
@Composable
private fun LoginScreenPreview() {
//    LoginScreen()
}