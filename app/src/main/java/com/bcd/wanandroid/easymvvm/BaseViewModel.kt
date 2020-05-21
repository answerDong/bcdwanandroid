package com.bcd.wanandroid.easymvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel

/**
 * @author D.chuang
 * @date 2020/5/12.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：页面
 */
abstract class BaseViewModel constructor(application: Application) : AndroidViewModel(application) {

    override fun onCleared() {
        super.onCleared()
    }
}