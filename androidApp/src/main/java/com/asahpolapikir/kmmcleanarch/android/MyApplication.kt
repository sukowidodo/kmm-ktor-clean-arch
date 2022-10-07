package com.asahpolapikir.kmmcleanarch.android

import android.app.Application
import com.asahpolapikir.kmmcleanarch.android.di.viewmodelmodule
import com.asahpolapikir.kmmcleanarch.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        startKoin {
            androidContext(this@MyApplication)
            androidLogger()
            modules(listOf(viewmodelmodule, appModule))
        }
    }
}
