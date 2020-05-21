package com.bcd.wanandroid.easymvvm.net

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 * @author D.chuang
 * @date 2020/5/14.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：页面
 */
class RetrofitManager private constructor() {
    private var retrofit: Retrofit? = null
    private var retrofitApiService: RetrofitApiService? = null
    init {
        initRetrofit()
    }
    private fun initRetrofit() {
        retrofit = Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        retrofitApiService = retrofit!!.create(RetrofitApiService::class.java)
    }

    fun getApiservice() : RetrofitApiService?{
        return retrofitManager!!.retrofitApiService
    }

    companion object {
        private var retrofitManager: RetrofitManager? = null
        val instance: RetrofitManager?
            get() {
                if (retrofitManager == null) {
                    synchronized(RetrofitManager::class.java) {
                        if (retrofitManager == null) {
                            retrofitManager = RetrofitManager()
                        }
                    }
                }
                return retrofitManager
            }

        val apiService: RetrofitApiService?
            get() = retrofitManager!!.retrofitApiService
    }


}
