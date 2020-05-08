package com.bcd.wanandroid.utils

import android.app.ActivityManager
import android.content.Context
import android.os.Process

/**
 * @author D.chuang
 * @date 2020/5/8.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：检查当前进程，判断是否是主进程
 */

fun isMainProcess(context : Context) =context.packageName == currentProcessName(context)

fun currentProcessName(context : Context) : String{
    var manager =context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    for (process in manager.runningAppProcesses){
        if(process.pid == Process.myPid()){
            return process.processName
        }
    }
    return ""
}