package com.bcd.wanandroid.retrofit

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Url

interface UserApiService {

    @POST
    @FormUrlEncoded
    fun login(@Url string: String,@Field("phone") mobile:String,@Field("pwd")pwd: String):Call<UserBean>
}