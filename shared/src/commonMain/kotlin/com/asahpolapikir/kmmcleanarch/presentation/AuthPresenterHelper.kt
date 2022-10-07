package com.asahpolapikir.kmmcleanarch.presentation

import com.asahpolapikir.kmmcleanarch.data.base.BaseResponse
import com.asahpolapikir.kmmcleanarch.data.base.BaseResult
import com.asahpolapikir.kmmcleanarch.domain.model.UserDomain
import com.asahpolapikir.kmmcleanarch.domain.usecase.AuthUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AuthPresenterHelper : KoinComponent {
    private val authRepo: AuthUseCase by inject()

    fun doLogin(email: String, password: String, result: (BaseResult<UserDomain>) -> Unit) {
        CoroutineScope(Dispatchers.Main).launch {
            authRepo.doLogin(email, password).collectLatest {
                when(it){
                    is BaseResponse.Loading -> result.invoke(BaseResult(loading = true))
                    is BaseResponse.Success -> result.invoke(BaseResult(data = it.data))
                    is BaseResponse.Error -> result.invoke(BaseResult(message = it.message))
                    else -> {}
                }
            }
        }
    }
}
