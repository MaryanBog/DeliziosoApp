package com.myproj.delizioso.screen.login.models

sealed class LoginEvent {
    object ActionClicked : LoginEvent()
    object ForgetClick: LoginEvent()
    data class CheckBoxClick(val value: Boolean): LoginEvent()
    data class EmailChanged(val value: String) : LoginEvent()
    data class PasswordChanged(val value: String) : LoginEvent()
}
