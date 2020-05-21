package com.bcd.wanandroid.easymvvm.databinding

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.ViewModelProvider
import com.bcd.wanandroid.R
import com.bcd.wanandroid.databinding.ActivityDatabindingBinding
import com.bcd.wanandroid.easymvvm.viewmodel.MyViewModel

/**
 * @author D.chuang
 * @date 2020/5/13.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：页面
 */
class databindingActivity : AppCompatActivity(),View.OnClickListener{
    
    private lateinit var binding: ActivityDatabindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_databinding)
        binding = setContentView(this, R.layout.activity_databinding);
//        binding.textstr = "测试"
        var user = User("xiaobai",18)
        binding.textstr = user
        binding.onClickListener = this
        var myViewModel = ViewModelProvider(this)[MyViewModel::class.java]
        Log.i("tag","Activity被杀死后xiaohui  oncreate"+myViewModel.hashCode())
    }

    override fun onClick(v: View?) {
//        binding.txt.text = " 改变值了"

    }

    override fun onStart() {
        super.onStart()
        var myViewModel = ViewModelProvider(this)[MyViewModel::class.java]
        Log.i("tag","Activity被杀死后xiaohui  onStart"+myViewModel.hashCode())
    }

    override fun onResume() {
        super.onResume()
        var myViewModel = ViewModelProvider(this)[MyViewModel::class.java]
        Log.i("tag","Activity被杀死后xiaohui  onResume"+myViewModel.hashCode())
    }

    override fun onPause() {
        super.onPause()
        var myViewModel = ViewModelProvider(this)[MyViewModel::class.java]
        Log.i("tag","Activity被杀死后xiaohui  onPause"+myViewModel.hashCode())
    }

    override fun onStop() {
        super.onStop()
        var myViewModel = ViewModelProvider(this)[MyViewModel::class.java]
        Log.i("tag","Activity被杀死后xiaohui  onStop"+myViewModel.hashCode())
    }

    override fun onDestroy() {
        super.onDestroy()
        var myViewModel = ViewModelProvider(this)[MyViewModel::class.java]
        Log.i("tag","Activity被杀死后xiaohui  onDestroy"+myViewModel.hashCode())
    }

}