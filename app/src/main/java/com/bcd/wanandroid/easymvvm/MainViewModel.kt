package com.bcd.wanandroid.easymvvm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.bcd.wanandroid.easymvvm.net.RetrofitManager
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * @author D.chuang
 * @date 2020/5/14.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：页面
 */
class MainViewModel constructor(application: Application) : BaseViewModel(application){

    override fun onCleared() {
        super.onCleared()
    }

    fun getBanners() : MutableLiveData<List<BannerBean>> {
        var livedata = MutableLiveData<List<BannerBean>>()
        var re = RetrofitManager
        RetrofitManager.instance?.getApiservice()?.getBanner()?.subscribeOn(Schedulers.io())?.subscribe {
            livedata.postValue(it.getData());
        }
        return livedata
    }
}