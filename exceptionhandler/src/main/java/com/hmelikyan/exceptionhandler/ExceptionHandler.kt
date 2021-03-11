package com.hmelikyan.exceptionhandler

import android.app.Application
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Build
import android.os.Process
import kotlin.system.exitProcess

internal object ExceptionHandler {

    lateinit var mApplication: Application

    fun init(application: Application) {
        mApplication = application
        if (getApplicationKey() == null)
            throw NullPointerException("Menu Group key not found")
    }

    @JvmStatic
    fun setExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            val model = ErrorDomain(osVersion = Build.VERSION.SDK_INT).apply {
                key = getApplicationKey()
                text = throwable.message
                manufacture = Build.MANUFACTURER
                deviceModel = Build.MODEL
            }

            val stackTrace = throwable.cause?.stackTrace
            if (!stackTrace.isNullOrEmpty()) {
                model.className = stackTrace[0]?.className
                model.crashLine = stackTrace[0]?.lineNumber ?: 0
            }
            val intent = Intent(mApplication, ExceptionActivity::class.java)
            intent.putExtra("model", model)
            intent.putExtra("packageName",    mApplication.packageName)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            mApplication.startActivity(intent)
            Process.killProcess(Process.myPid())
            exitProcess(10)
        }
    }

    private fun getApplicationKey(): String? {
        val app: ApplicationInfo? = mApplication.packageManager?.getApplicationInfo(mApplication.packageName, PackageManager.GET_META_DATA)
        val bundle = app?.metaData
        return bundle?.getString("co.uk.MenuKey")
    }
}