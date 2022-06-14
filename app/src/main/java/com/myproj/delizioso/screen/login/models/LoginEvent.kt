package com.myproj.delizioso.screen.login.models

sealed class LoginEvent {
    object LoginActionInvoked: LoginEvent()
    object ActionClicked : LoginEvent()
    object ForgetClicked: LoginEvent()
    object LoginClicked: LoginEvent()
    data class CheckBoxClicked(val value: Boolean): LoginEvent()
    data class EmailChanged(val value: String) : LoginEvent()
    data class PasswordChanged(val value: String) : LoginEvent()
}
