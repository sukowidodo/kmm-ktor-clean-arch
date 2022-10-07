package com.asahpolapikir.kmmcleanarch.data.base

import kotlinx.serialization.Serializable

@Serializable
data class WrapResponse<T>(
    val code: Int,
    val message: String,
    val result: T? = null
)
