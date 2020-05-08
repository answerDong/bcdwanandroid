package com.bcd.wanandroid

import android.app.Activity
import android.app.Application
import com.bcd.wanandroid.common.ActivityLifecycleCallbacksAdapter
import com.bcd.wanandroid.model.store.SettingsStore
import com.bcd.wanandroid.utils.core.ActivityManager
import com.bcd.wanandroid.utils.isMainProcess
import com.bcd.wanandroid.utils.setNightMode

/**
 * @author D.chuang
 * @date 2020/5/8.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：application类  程序入口类
 */

class App : Application(){

    //创建单例模式
    companion object{
        lateinit var instance : App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        //主进程初始化，判断当前是否是主进程
        if(isMainProcess(this)){
            init()
        }
    }

    private fun init(){
        rigesterActivityCallbacks()
        setDayNightMode()
    }


    /**
     * 设置显示模式
     */
    private fun setDayNightMode() {
        setNightMode(SettingsStore.getNightMode())
    }

    private fun rigesterActivityCallbacks() {
        registerActivityLifecycleCallbacks(
            ActivityLifecycleCallbacksAdapter(
                onActivityCreated = { activity, _ ->
                    ActivityManager.activities.add(activity)
                },
                onActivityDestroyed = {activity ->
                    ActivityManager.activities.remove(activity)
                }
            )
        )
    }
}