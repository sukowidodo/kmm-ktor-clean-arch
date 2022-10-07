package com.asahpolapikir.kmmcleanarch.ext

import com.asahpolapikir.kmmcleanarch.data.base.BaseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

fun <T, X> castDataFlow(req: suspend () -> BaseResponse<T>, result: (T) -> X): Flow<BaseResponse<X>> {
    return flow {
        emit(BaseResponse.Loading())
        val data = when (val param = req.invoke()) {
            is BaseResponse.Success -> BaseResponse.Success(
                param.data?.let {
                    result.invoke(
                        it
                    )
                },
                param.message
            )
            is BaseResponse.Loading -> BaseResponse.Loading()
            is BaseResponse.Logout -> BaseResponse.Logout()
            is BaseResponse.Error -> BaseResponse.Error(param.e)
        }
        emit(data)
    }.flowOn(Dispatchers.Default)
}