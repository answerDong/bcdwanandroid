package com.bcd.wanandroid.easymvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author D.chuang
 * @date 2020/5/13.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：页面
 */
class LivewDataViewModel : ViewModel(){

    private var namelivedata = MutableLiveData<String>()

    fun getData():MutableLiveData<String>{
        return namelivedata
    }
}