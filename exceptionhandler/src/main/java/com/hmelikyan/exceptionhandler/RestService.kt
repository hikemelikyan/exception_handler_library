package com.hmelikyan.exceptionhandler

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class RestService {

    private var retrofit: Retrofit

    init {
        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        retrofit = Retrofit.Builder()
            .baseUrl("https://hooks.slack.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun getRetrofitInstance(): IExceptionSendDeveloperControllerAPI {
        return retrofit.create(IExceptionSendDeveloperControllerAPI::class.java)
    }
}