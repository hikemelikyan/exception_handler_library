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
    var className: String? = null,
    var crashLine: Int = 0,
    var osVersion: Int,
    var manufacture: String? = null,
    var deviceModel: String? = null
) : Parcelable {

    fun requiredMessage() {
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
        className?.let {
            sb.append("Classname: $className ,line $crashLine \n")
        }
        text?.let {
            sb.append("Cause: $it")
        }
        text = sb.toString()
    }

}