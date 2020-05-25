package com.bcd.wanandroid.mvvmdemo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bcd.wanandroid.R
import com.bcd.wanandroid.databinding.ActivityAnimalBinding

/**
 * @author D.chuang
 * @date 2020/5/25.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：页面
 */
class animalsActivity : AppCompatActivity(){
    private lateinit var binding : ActivityAnimalBinding
    private lateinit var mviewmodel: AnimalsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_animal)
        val animals = Animals("狗子",0)
        mviewmodel = AnimalsViewModel(animals)
        binding.vm = mviewmodel

    }
}