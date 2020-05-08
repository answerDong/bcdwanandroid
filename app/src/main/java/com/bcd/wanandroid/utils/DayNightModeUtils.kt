package com.bcd.wanandroid.utils

import android.util.Log
import android.view.Display
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES

/**
 * @author D.chuang
 * @date 2020/5/8.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：页面
 */

/**
 * 设置黑夜模式
 */
fun setNightMode(isNightMode : Boolean){
    Log.i("tag","=======$isNightMode")
    AppCompatDelegate.setDefaultNightMode(if(isNightMode) MODE_NIGHT_YES else MODE_NIGHT_NO)
}