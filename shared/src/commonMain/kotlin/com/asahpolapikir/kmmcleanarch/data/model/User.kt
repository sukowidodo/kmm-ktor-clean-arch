package com.asahpolapikir.kmmcleanarch.data.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val token: String? = null,
    val email: String? = null
)
