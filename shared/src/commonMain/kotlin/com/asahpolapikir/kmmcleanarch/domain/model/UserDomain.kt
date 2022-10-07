package com.asahpolapikir.kmmcleanarch.domain.model

import com.asahpolapikir.kmmcleanarch.data.model.User

data class UserDomain(
    val token: String,
    val email: String
){
    constructor(user: User) : this(
        token = user.token ?: "",
        email = user.email ?: ""
    )
}