package com.asahpolapikir.kmmcleanarch.data.repository

import com.asahpolapikir.kmmcleanarch.constant.BASE_URL
import com.asahpolapikir.kmmcleanarch.data.base.BaseResponse
import com.asahpolapikir.kmmcleanarch.data.base.BaseResult
import com.asahpolapikir.kmmcleanarch.data.base.WrapResponse
import com.asahpolapikir.kmmcleanarch.data.httpClient
import com.asahpolapikir.kmmcleanarch.data.initLogger
import com.asahpolapikir.kmmcleanarch.data.model.User
import com.asahpolapikir.kmmcleanarch.data.payload.LoginPayload
import io.github.aakira.napier.Napier
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class AuthDataStore : AuthRepository {
    private val httpClient = httpClient {
        install(Logging) {
            level = LogLevel.BODY
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.d(message, tag = "http request")
                }
            }
        }
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                }
            )
        }
    }.also { initLogger() }

    override suspend fun doLogin(email: String, password: String) : BaseResponse<User?>{
        val responseData = httpClient.post("$BASE_URL/login") {
            contentType(ContentType.Application.Json)
            setBody(
                LoginPayload(
                    email,
                    password
                )
            )
        }

        val resp = responseData.body<WrapResponse<User>>()
        return when (responseData.status.value) {
            in 200..299 -> {
                BaseResponse.Success(resp.result)
            }
            else -> {
                BaseResponse.Error(Exception(resp.message))
            }
        }
    }
}
