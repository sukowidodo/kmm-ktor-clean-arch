package com.asahpolapikir.kmmcleanarch.data.repository

import com.asahpolapikir.kmmcleanarch.data.base.BaseResponse
import com.asahpolapikir.kmmcleanarch.data.model.User

interface AuthRepository {
    suspend fun doLogin(email: String, password: String): BaseResponse<User?>
}
