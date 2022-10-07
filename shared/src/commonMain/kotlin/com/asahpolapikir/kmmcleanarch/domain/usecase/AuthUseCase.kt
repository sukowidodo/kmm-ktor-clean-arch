package com.asahpolapikir.kmmcleanarch.domain.usecase

import com.asahpolapikir.kmmcleanarch.data.base.BaseResponse
import com.asahpolapikir.kmmcleanarch.domain.model.UserDomain
import kotlinx.coroutines.flow.Flow

interface AuthUseCase {
    suspend fun doLogin(email: String, password: String): Flow<BaseResponse<UserDomain>>
}
