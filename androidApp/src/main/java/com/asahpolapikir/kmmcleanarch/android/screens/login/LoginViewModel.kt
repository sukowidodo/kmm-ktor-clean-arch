package com.asahpolapikir.kmmcleanarch.android.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asahpolapikir.kmmcleanarch.data.base.BaseResponse
import com.asahpolapikir.kmmcleanarch.data.base.BaseResult
import com.asahpolapikir.kmmcleanarch.domain.model.UserDomain
import com.asahpolapikir.kmmcleanarch.domain.usecase.AuthUseCase
import kotlinx.coroutines.launch

class LoginViewModel(
    val authUseCase: AuthUseCase
) : ViewModel() {

    fun doLogin(
        email: String,
        password: String,
        onResult: (BaseResponse<UserDomain>) -> Unit
    ) = viewModelScope.launch {
        authUseCase.doLogin(email, password).collect {
            onResult.invoke(it)
        }
    }
}
