package com.bcd.wanandroid.mvvmdemo.model.remote

import com.bcd.wanandroid.mvvmdemo.model.data.Article
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author D.chuang
 * @date 2020/5/25.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：页面
 */
interface PaoService {
    @GET("article_detail.php")
    fun getArticleDetail(@Query("id") id: Int): Single<Article>
}