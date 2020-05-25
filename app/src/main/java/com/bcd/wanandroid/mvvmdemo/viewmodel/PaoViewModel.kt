package com.bcd.wanandroid.mvvmdemo.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.bcd.wanandroid.mvvmdemo.model.data.Article
import com.bcd.wanandroid.mvvmdemo.model.remote.PaoService
import io.reactivex.Scheduler
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * @author D.chuang
 * @date 2020/5/25.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：页面
 */
class PaoViewModel(val remote :PaoService) : ViewModel(){
    val articleDetail = ObservableField<String>()
    fun loadArticle() {
        remote.getArticleDetail(8773)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Article> {
                override fun onSuccess(t: Article) {
                    articleDetail.set(t?.toString())
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    articleDetail.set(e?.toString()?:"error")
                }

            })
    }
}