package com.bcd.wanandroid.mvvmdemo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bcd.wanandroid.R
import com.bcd.wanandroid.databinding.ActivityMvvmBinding
import com.bcd.wanandroid.databinding.ActivityPaoBinding
import com.bcd.wanandroid.mvvmdemo.AnimalsViewModel
import com.bcd.wanandroid.mvvmdemo.model.remote.PaoService
import com.bcd.wanandroid.mvvmdemo.viewmodel.PaoViewModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author D.chuang
 * @date 2020/5/25.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：页面
 */
class PaoActivity : AppCompatActivity(){

    lateinit var binding: ActivityPaoBinding
    lateinit var mviewmodel :PaoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pao)
        val remote= Retrofit.Builder()
            .baseUrl("http://api.jcodecraeer.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(PaoService::class.java)
        mviewmodel = PaoViewModel(remote)
        binding.vm = mviewmodel


    }
}