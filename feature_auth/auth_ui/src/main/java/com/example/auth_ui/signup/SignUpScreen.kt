package com.example.auth_ui.signup

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
fun SignUpScreen(
    states: SignUpUiState,
    events: (Events) -> Unit,
    onLoginClicked: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Text(
            "SIGNUP",
            color = Color.Black,
            fontSize = dimensionResource(id = com.example.core_ui.R.dimen.sp_44).value.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily(Font(com.example.core_ui.R.font.league_spartan_variable)),
        )

        CustomTextField(
            value = states.email,
            onValueChange = { events(Events.OnEmailChange(it)) },
            labelResId = R.string.email,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.email),
                    modifier = Modifier.size(dimensionResource(id = com.example.core_ui.R.dimen.dp_20)),
                    contentDescription = null
                )
            },
        )

        CustomTextField(
            value = states.password,
            onValueChange = { events(Events.OnPasswordChange(it)) },
            labelResId = R.string.password,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.lock),
                    modifier = Modifier.size(dimensionResource(id = com.example.core_ui.R.dimen.dp_20)),
                    contentDescription = null
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_key_24),
                    modifier = Modifier.size(dimensionResource(id = com.example.core_ui.R.dimen.dp_20)),
                    contentDescription = null,
                    tint = Color.DarkGray
                )
            },
        )

        CustomTextField(
            value = states.confirmPassword,
            onValueChange = { events(Events.OnConfirmPasswordChange(it)) },
            labelResId = R.string.confirm_password,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.lock),
                    modifier = Modifier.size(dimensionResource(id = com.example.core_ui.R.dimen.dp_20)),
                    contentDescription = null
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_key_24),
                    modifier = Modifier.size(dimensionResource(id = com.example.core_ui.R.dimen.dp_20)),
                    contentDescription = null,
                    tint = Color.DarkGray
                )
            },
        )

        states.error?.let {
            Text(
                text = it.toString(),
                color = Color.Red,
                fontSize = dimensionResource(id = com.example.core_ui.R.dimen.sp_15).value.sp
            )
        }

        CustomButton(
            text = stringResource(R.string.sign_up_),
            onClick = { events(Events.OnSignUpClicked) },
            isLoading = states.isLoading
        )

        AccountRow(
            labelText = stringResource(R.string.already_have_an_account),
            actionText = stringResource(R.string.login_),
            onActionClick = onLoginClicked
        )
    }
}


@Preview
@Composable
private fun LoginScreenPreview() {
//    SignUpScreen()
}