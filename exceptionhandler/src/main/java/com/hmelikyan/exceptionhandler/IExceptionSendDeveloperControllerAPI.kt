package com.hmelikyan.exceptionhandler

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

internal interface IExceptionSendDeveloperControllerAPI {
    @POST("/services/TCQ88S39S/B01R96G7789/TPgkrOtDhStmzQBxBg9ZPWe5")
    fun loadChanges(@Body model: ErrorDomain?): Call<Any?>?
}