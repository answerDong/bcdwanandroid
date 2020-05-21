package com.bcd.wanandroid.easymvvm

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * @author D.chuang
 * @date 2020/5/14.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：页面
 */
class MyObserver : LifecycleObserver{
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun  onCreate(){
        Log.i("tag","===========或得到的结果onCreate")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(){
        Log.i("tag","===========onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(){
        Log.i("tag","===========ON_RESUME")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(){
        Log.i("tag","===========ON_PAUSE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(){
        Log.i("tag","===========ON_STOP")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestory(){
        Log.i("tag","===========ON_DESTROY")
    }
}