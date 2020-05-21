package com.bcd.wanandroid.easymvvm.net

import com.bcd.wanandroid.easymvvm.BannerBean

import com.bcd.wanandroid.easymvvm.ResponModel
import io.reactivex.Observable

import retrofit2.http.GET




/**
 * @author D.chuang
 * @date 2020/5/14.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：页面
 */
interface RetrofitApiService {
    @GET("banner/json")
    fun getBanner(): Observable<ResponModel<List<BannerBean>>>
}