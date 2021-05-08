package com.hmelikyan.exceptionhandler

import android.os.Build
import android.os.Build.VERSION_CODES
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.lang.reflect.Field


@Parcelize
data class ErrorDomain(
    var applicationPackage: String? = null,
    var key: String? = null,
    var text: String? = null,
    var stackTrace:String? = null,
    var className: String? = null,
    var threadName:String? = null,
    var crashLine: Int = 0,
    var osVersion: Int,
    var manufacture: String? = null,
    var deviceModel: String? = null
) : Parcelable {

    override fun toString(): String {
        val sb = StringBuilder()
        key?.let {
            sb.append("Application Type: $it \n")
        }
        applicationPackage?.let {
            sb.append("Application Package: $it \n")
        }
        val fields: Array<Field> = VERSION_CODES::class.java.fields
        val osName: String = fields[Build.VERSION.SDK_INT].name

        sb.append("OS Version: $osVersion , OS Name: $osName \n")
        manufacture?.let {
            sb.append("Device Info: $it ,")
        }
        deviceModel?.let {
            sb.append("$it \n")
        }
        threadName?.let {
            sb.append("Thread: $it \n")
        }
        className?.let {
            sb.append("CrashLine: $className ,line $crashLine \n")
        }
        text?.let {
            sb.append("Cause: $it \n")
        }
        stackTrace?.let {
            sb.append("StackTrace: $it")
        }
        text = sb.toString()
        return sb.toString()
    }

}