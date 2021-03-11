package com.hmelikyan.exceptionhandler

fun startExceptionHandler(application: HandlerApplication) {
    ExceptionHandler.init(application)
    application.registerActivityLifecycleCallbacks(CrashReporterActivityLifecycleCallback())
}