package com.bcd.wanandroid.ui.splash

import android.os.Bundle
import com.bcd.wanandroid.ui.main.MainActivity
import com.bcd.wanandroid.R
import com.bcd.wanandroid.ui.base.BaseActivity
import com.bcd.wanandroid.utils.core.ActivityManager

/**
 * @author D.chuang
 * @date 2020/5/8.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：页面
 */
class SplashActivity : BaseActivity(){

    override fun layoutRes(): Int {
        return R.layout.activity_splash
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.postDelayed({
            ActivityManager.start(MainActivity::class.java)
            ActivityManager.finish(SplashActivity::class.java)
        }, 1000)
    }
}