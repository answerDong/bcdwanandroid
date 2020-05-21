package com.bcd.wanandroid.easymvvm.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

/**
 * @author D.chuang
 * @date 2020/5/13.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：页面
 */
class MyViewModel : ViewModel(){
    override fun onCleared() {
        super.onCleared()
        Log.i("tag","Activity被杀死后xiaohui")
    }
}