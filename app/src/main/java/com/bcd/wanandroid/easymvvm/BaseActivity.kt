package com.bcd.wanandroid.easymvvm

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding

/**
 * @author D.chuang
 * @date 2020/5/12.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description： mvvm地址 https://blog.csdn.net/leol_2/article/details/102612577
 */
abstract class BaseActivity<VM :BaseViewModel,VDB : ViewDataBinding> : AppCompatActivity(){


    //获取activity布局文件，并初始化binding
    protected abstract fun getContentViewId():Int

    //处理逻辑业务
    protected abstract fun processLogic()


}