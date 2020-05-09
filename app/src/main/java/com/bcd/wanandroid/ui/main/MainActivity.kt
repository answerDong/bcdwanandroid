package com.bcd.wanandroid.ui.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import com.bcd.wanandroid.R
import com.bcd.wanandroid.ui.base.BaseActivity

class MainActivity : BaseActivity() {
    lateinit var fragments : Map<Int,Fragment>

    //设置主界面布局
    override fun layoutRes(): Int = R.layout.activity_main

    /**
     * 在这里我们要做的就是将显示的fragment添加到帧布局fl中
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }




}
