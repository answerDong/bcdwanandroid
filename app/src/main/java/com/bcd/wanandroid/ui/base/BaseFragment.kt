package com.bcd.wanandroid.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * @author D.chuang
 * @date 2020/5/9.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：fragment基类
 */
class BaseFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutRes(),container,false)
    }

    /**
     * 返回布局
     */
    open fun layoutRes() = 0
}