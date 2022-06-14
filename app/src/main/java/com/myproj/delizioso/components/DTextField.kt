package com.myproj.delizioso.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myproj.delizioso.ui.theme.AppTheme

@Composable
fun DTextField(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String,
    secureText: Boolean = false,
    enabled: Boolean = true,
    onValueChange: (String) -> Unit
) {
    TextField(
        modifier = modifier,
        value = value,
        enabled = enabled,
        placeholder = {
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = placeholder,
                style = TextStyle(
                    color = AppTheme.color.hintTextColor,
                    fontSize = 12.sp
                )
            )
        },
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = AppTheme.color.primaryTextColor,
            backgroundColor = AppTheme.color.secondaryBackground,
            disabledIndicatorColor = AppTheme.color.primaryBackground,
            errorIndicatorColor = AppTheme.color.primaryBackground,
            focusedIndicatorColor = AppTheme.color.primaryBackground,
            unfocusedIndicatorColor = AppTheme.color.primaryBackground
        ),
        visualTransformation = if (secureText) PasswordVisualTransformation() else
            VisualTransformation.None,
        onValueChange = onValueChange

    )
}