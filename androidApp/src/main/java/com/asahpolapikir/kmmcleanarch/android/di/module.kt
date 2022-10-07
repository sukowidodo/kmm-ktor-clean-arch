package com.asahpolapikir.kmmcleanarch.android.di

import com.asahpolapikir.kmmcleanarch.android.screens.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelmodule = module {
    viewModel { LoginViewModel(get()) }
}
