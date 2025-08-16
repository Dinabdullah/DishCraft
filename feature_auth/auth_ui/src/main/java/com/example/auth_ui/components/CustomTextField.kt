package com.example.auth_ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.auth_ui.R

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    labelResId: Int,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,

    ) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(labelResId), color = Color.DarkGray) },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        modifier = modifier.padding(
            vertical = dimensionResource(com.example.core_ui.R.dimen.dp_12),
            horizontal = dimensionResource(com.example.core_ui.R.dimen.dp_12)
        ),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.Black,
            unfocusedIndicatorColor = Color.LightGray,
            focusedLabelColor = Color.DarkGray,
        )
    )
}

@Preview
@Composable
fun CustomTextFieldPreview(modifier: Modifier = Modifier) {
    CustomTextField(
        value = "",
        onValueChange = {},
        labelResId = R.string.email,
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.email),
                modifier = Modifier.size(dimensionResource(id = com.example.core_ui.R.dimen.dp_20)),
                contentDescription = null,
            )
        },
        trailingIcon = {},
        visualTransformation = VisualTransformation.None,

        )
}