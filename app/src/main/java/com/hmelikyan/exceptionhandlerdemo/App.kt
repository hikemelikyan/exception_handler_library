package com.hmelikyan.exceptionhandlerdemo

import android.app.Application
import com.hmelikyan.exceptionhandler.startExceptionHandler

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startExceptionHandler(this)
    }
}