package com.myproj.delizioso.screen.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myproj.delizioso.common.EventHandler
import com.myproj.delizioso.screen.login.models.LoginEvent
import com.myproj.delizioso.screen.login.models.LoginSubState
import com.myproj.delizioso.screen.login.models.LoginViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel(), EventHandler<LoginEvent> {

    private val _viewState = MutableLiveData(LoginViewState())
    val viewState: LiveData<LoginViewState> = _viewState

    override fun obtainEvent(event: LoginEvent) {
        when (event) {
            LoginEvent.ActionClicked -> switchActionState()
            is LoginEvent.EmailChanged -> emailChanged(event.value)
            is LoginEvent.PasswordChanged -> passwordChange(event.value)
            is LoginEvent.ForgetClick -> forgetClicked()
            is LoginEvent.CheckBoxClick -> checkBoxClicked(event.value)
        }
    }

    private fun checkBoxClicked(value: Boolean){
        _viewState.postValue(_viewState.value?.copy(rememberMeChecked = value))
    }

    private fun forgetClicked(){
        _viewState.postValue(_viewState.value?.copy(loginSubState = LoginSubState.Forgot))
    }

    private fun emailChanged(value: String) {
        _viewState.postValue(_viewState.value?.copy(emailValue = value))
    }

    private fun passwordChange(value: String) {
        _viewState.postValue(_viewState.value?.copy(passwordValue = value))
    }

    private fun switchActionState() {
        when (_viewState.value?.loginSubState) {
            LoginSubState.SignUp -> _viewState.postValue(_viewState.value?.copy(loginSubState = LoginSubState.SignIn))
            LoginSubState.SignIn -> _viewState.postValue(_viewState.value?.copy(loginSubState = LoginSubState.SignUp))
            else -> {}
        }

    }
}