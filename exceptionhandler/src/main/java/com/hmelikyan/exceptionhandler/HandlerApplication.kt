package com.hmelikyan.exceptionhandler

import android.app.Application

abstract class HandlerApplication : Application() {
    abstract fun restartApplication()
}