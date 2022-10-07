package com.asahpolapikir.kmmcleanarch.data.base

sealed class BaseResponse<out T>(
    val data: T? = null,
    val message: String? = null,
    val e: Throwable? = null
) {
    class Success<T>(data: T?, message: String? = null) : BaseResponse<T>(data, message)
    class Loading<T> : BaseResponse<T>()
    class Error<T>(e: Throwable?, data: T? = null) : BaseResponse<T>(data, null, e)
    class Logout<T> : BaseResponse<T>()
}
