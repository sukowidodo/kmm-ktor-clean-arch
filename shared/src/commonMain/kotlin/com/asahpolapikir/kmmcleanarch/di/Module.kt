package com.asahpolapikir.kmmcleanarch.di

import com.asahpolapikir.kmmcleanarch.data.repository.AuthDataStore
import com.asahpolapikir.kmmcleanarch.data.repository.AuthRepository
import com.asahpolapikir.kmmcleanarch.domain.usecase.AuthInteractor
import com.asahpolapikir.kmmcleanarch.domain.usecase.AuthUseCase
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {
    single<AuthRepository> { AuthDataStore() }
    single<AuthUseCase> { AuthInteractor(get()) }
}