package com.asahpolapikir.kmmcleanarch.domain.usecase

import com.asahpolapikir.kmmcleanarch.data.model.User
import com.asahpolapikir.kmmcleanarch.data.repository.AuthRepository
import com.asahpolapikir.kmmcleanarch.domain.model.UserDomain
import com.asahpolapikir.kmmcleanarch.ext.castDataFlow

class AuthInteractor(
    val authRepository: AuthRepository
) : AuthUseCase {
    override suspend fun doLogin(
        email: String,
        password: String
    ) = castDataFlow({ authRepository.doLogin(email, password) }) {
        UserDomain(it ?: User())
    }
}
