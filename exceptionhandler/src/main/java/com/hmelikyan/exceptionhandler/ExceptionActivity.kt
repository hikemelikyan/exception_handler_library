package com.hmelikyan.exceptionhandler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hmelikyan.exceptionhandler.databinding.ActivityExceptionDetailsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExceptionActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityExceptionDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityExceptionDetailsBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.restartApplication.setOnClickListener {
            val appPackage = intent.getStringExtra("packageName")
            if (appPackage != null) {
                ExceptionHandler.mApplication.restartApplication()
            }
        }

        val model = intent.getParcelableExtra<ErrorDomain>("model")

        val iService = RestService().getRetrofitInstance()

        val call = iService.loadChanges(model?.apply { toString() })

        call?.enqueue(object : Callback<Any?> {
            override fun onResponse(call: Call<Any?>, response: Response<Any?>) {}
            override fun onFailure(call: Call<Any?>, t: Throwable) {}
        })
    }
}