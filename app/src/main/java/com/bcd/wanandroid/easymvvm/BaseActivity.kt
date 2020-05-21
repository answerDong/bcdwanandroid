package com.bcd.wanandroid.easymvvm

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import org.jetbrains.annotations.Nullable
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type


/**
 * @author D.chuang
 * @date 2020/5/12.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description： mvvm地址 https://blog.csdn.net/leol_2/article/details/102612577
 */
//ViewDataBinding 是所有DataBinding的父类
abstract class BaseActivity<VM : BaseViewModel?> : AppCompatActivity() {
    //获取当前activity布局文件,并初始化我们的binding
    protected abstract fun getContentViewId(): Int

    protected abstract fun getActivity() : Activity

    //处理逻辑业务
    protected abstract fun processLogic()

    protected abstract fun createbinding()
    protected var mViewModel: VM? = null
//    protected var binding: VDB? = null
    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentViewId())

        //初始化我们的binging
//        binding = DataBindingUtil.setContentView(getActivity(), getContentViewId())
//        //给binding加上感知生命周期，AppCompatActivity就是lifeOwner，之前解释过了，不懂看前面
//        binding?.lifecycleOwner = this
        //创建我们的ViewModel。
        createbinding()
        createViewModel()
        processLogic()
    }

    private fun createViewModel() {
        if (mViewModel == null) {
            var modelClass: Class<VM>
            val type: Type? = javaClass.genericSuperclass
            modelClass = (if (type is ParameterizedType) {
                type.actualTypeArguments[0]
            } else {
                //如果没有指定泛型参数，则默认使用BaseViewModel
                BaseViewModel::class.java
            }) as Class<VM>
            mViewModel = ViewModelProvider(this)[modelClass]
        }

    }

}
