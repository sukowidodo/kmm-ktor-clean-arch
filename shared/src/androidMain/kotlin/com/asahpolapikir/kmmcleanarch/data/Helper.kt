package com.asahpolapikir.kmmcleanarch.data

import com.asahpolapikir.kmmcleanarch.di.appModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(appModule)
    }
}

