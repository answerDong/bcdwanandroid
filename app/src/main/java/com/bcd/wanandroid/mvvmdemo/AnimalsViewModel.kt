package com.bcd.wanandroid.mvvmdemo

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import io.reactivex.internal.operators.observable.ObservableFlatMap

/**
 * @author D.chuang
 * @date 2020/5/25.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：页面
 */
class AnimalsViewModel(val animals: Animals) : ViewModel(){
    var info = ObservableField<String>("${animals.name} 叫了 ${animals.shoutCount}声")

    fun shout(){
        animals.shoutCount++
        info.set("${animals.name} 叫了 ${animals.shoutCount}声")
    }

}