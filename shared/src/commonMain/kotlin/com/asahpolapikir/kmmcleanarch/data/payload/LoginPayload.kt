package com.asahpolapikir.kmmcleanarch.data.payload

import kotlinx.serialization.Serializable

@Serializable
data class LoginPayload(
    val email: String,
    val password: String
)
