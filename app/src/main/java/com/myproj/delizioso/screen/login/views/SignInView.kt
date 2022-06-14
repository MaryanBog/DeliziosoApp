package com.myproj.delizioso.screen.login.views

import android.widget.CompoundButton
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.myproj.delizioso.R
import com.myproj.delizioso.components.DTextField
import com.myproj.delizioso.components.TextInput
import com.myproj.delizioso.screen.login.models.LoginViewState
import com.myproj.delizioso.ui.theme.AppTheme

@Composable
fun SignInView(
    viewState: LoginViewState,
    onLoginFieldChange: (String) -> Unit,
    onPasswordFieldChange: (String) -> Unit,
    onCheckedChange: (Boolean) -> Unit,
    onForgetClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextInput(
            modifier = Modifier.padding(top = 50.dp),
            header = stringResource(id = R.string.email_hint),
            textFieldValue = viewState.emailValue,
            enabled = !viewState.isProgress,
            onTextFieldChange = {
                if (!viewState.isProgress)
                    onLoginFieldChange.invoke(it)
            }
        )

        TextInput(
            modifier = Modifier.padding(top = 30.dp),
            header = stringResource(id = R.string.password_hint),
            textFieldValue = viewState.passwordValue,
            enabled = !viewState.isProgress,
            secureText = true,
            onTextFieldChange = {
                if (!viewState.isProgress)
                    onPasswordFieldChange.invoke(it)
            }
        )

        Row(
            modifier = Modifier.padding(top = 40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = viewState.rememberMeChecked,
                onCheckedChange = onCheckedChange,
                enabled = !viewState.isProgress,
                colors = CheckboxDefaults.colors(
                    checkedColor = AppTheme.color.primaryTintColor,
                    uncheckedColor = AppTheme.color.borderColor
                )
            )

            Text(text = stringResource(id = R.string.remember_check_title))

            Spacer(modifier = Modifier.weight(1f))

            Text(
                modifier = if (viewState.isProgress) Modifier else Modifier.clickable(onClick = onForgetClick),
                text = stringResource(id = R.string.sing_in_forget)
            )
        }

        Button(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .height(60.dp),
            onClick = {
                if (!viewState.isProgress)
                    onLoginClick.invoke()
            },
            shape = RoundedCornerShape(size = 10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = AppTheme.color.primaryTintColor
            )
        ) {
            if (viewState.isProgress) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    strokeWidth = 2.dp,
                    color = AppTheme.color.primaryTextInvertColor
                )
            } else {
                Text(
                    text = stringResource(id = R.string.action_login),
                    fontWeight = FontWeight.Medium,
                    color = AppTheme.color.primaryTextInvertColor
                )
            }

        }

        Text(
            modifier = Modifier.padding(top = 100.dp),
            text = stringResource(id = R.string.copyright_bottom),
            color = AppTheme.color.hiddenColor
        )
    }
}