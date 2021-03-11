package com.hmelikyan.exceptionhandlerdemo

import com.hmelikyan.exceptionhandler.HandlerApplication
import com.hmelikyan.exceptionhandler.startExceptionHandler

class App : HandlerApplication() {

    override fun onCreate() {
        super.onCreate()
        startExceptionHandler(this)
    }

    override fun restartApplication() {
        val launchIntent = packageManager.getLaunchIntentForPackage(packageName)
        startActivity(launchIntent)
    }
}