package com.hmelikyan.exceptionhandlerdemo

import android.content.Intent
import com.hmelikyan.exceptionhandler.HandlerApplication
import com.hmelikyan.exceptionhandler.startExceptionHandler

class App : HandlerApplication() {

    override fun onCreate() {
        super.onCreate()
        startExceptionHandler(this)
    }

    override fun restartApplication() {
        val launchIntent = Intent(this,MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        startActivity(launchIntent)
    }
}