package com.hmelikyan.exceptionhandler

import android.app.Application

fun startExceptionHandler(application: Application) {
    ExceptionHandler.init(application)
    application.registerActivityLifecycleCallbacks(CrashReporterActivityLifecycleCallback())
}