package com.bcd.wanandroid.ui.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.bcd.wanandroid.common.ProgressDialogFragment

/**
 * @author D.chuang
 * @date 2020/5/8.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：页面
 */
abstract class BaseActivity : AppCompatActivity(){
    lateinit var progressDialogFragment : ProgressDialogFragment
    /**
     * 加载状态有4种：
     * 1.整页数据加载，加载动画在页面中间
     * 2.下拉刷新
     * 3.分页加载更多
     * 4.数据提交服务器加载对话框
     */

    /**
     * 加载结果：
     * 1.空，无数据
     * 2.无网络
     * 3.失败，点击重试
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())
    }

    /**
     * 返回布局
     */
    open fun layoutRes() = 0

    fun gotoActivity(cls : Class<out Activity>,isfinish : Boolean = true){
        val intent = Intent(this,cls);
        startActivity(intent)
        if(isfinish){
            finish()
        }
    }

    fun showProgressDialog(@StringRes message: Int) {

        if (!this::progressDialogFragment.isInitialized) {
            progressDialogFragment = ProgressDialogFragment.newInstance()
        }
        progressDialogFragment.show(supportFragmentManager, message, false)
    }

    fun hideProgressDialog() {
        if (this::progressDialogFragment.isInitialized && progressDialogFragment.isVisible) {
            progressDialogFragment.dismiss()
        }
    }
}