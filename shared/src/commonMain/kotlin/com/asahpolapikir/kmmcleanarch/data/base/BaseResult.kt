package com.asahpolapikir.kmmcleanarch.data.base

class BaseResult<out T>(
    val loading: Boolean? = false,
    val data: T? = null,
    val message: String? = null,
    val e: Throwable? = null
)