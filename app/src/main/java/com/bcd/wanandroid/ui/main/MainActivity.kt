package com.bcd.wanandroid.ui.main


import android.appwidget.AppWidgetProviderInfo
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bcd.wanandroid.R
import com.bcd.wanandroid.retrofit.Api
import com.bcd.wanandroid.retrofit.UserApiService
import com.bcd.wanandroid.retrofit.UserBean
import com.bcd.wanandroid.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : BaseActivity() {
    lateinit var fragments : Map<Int,Fragment>

    //设置主界面布局
    override fun layoutRes(): Int = R.layout.activity_main

    /**
     * 在这里我们要做的就是将显示的fragment添加到帧布局fl中
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        button.setOnClickListener { login()  }


    }

    fun login(){
        Toast.makeText(this, "login", Toast.LENGTH_SHORT).show()

        var mobile: String = "18612991023"
        var pwd = "111111"
        //日志拦截器
        var httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        //Okhttp对象
        var okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        //创建Retrofit对象
        var retrofit = Retrofit.Builder().baseUrl(Api.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()

        //创建请求接口类
        var userApiService = retrofit.create(UserApiService::class.java)

        userApiService.login(Api.LOGIN_URL,mobile,pwd).enqueue(object : retrofit2.Callback<UserBean>{
            override fun onFailure(call: Call<UserBean>, t: Throwable) {
                Log.i("tag","==================userBean$t")
            }

            override fun onResponse(call: Call<UserBean>, response: Response<UserBean>) {
               var userBean = response.body()
                Log.i("tag","==================userBean$userBean")
            }

        })
    }


}
