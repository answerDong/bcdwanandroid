package com.bcd.wanandroid.easymvvm.databinding

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bcd.wanandroid.R
import com.bcd.wanandroid.databinding.ActivityLivedataBinding
import com.bcd.wanandroid.easymvvm.viewmodel.LivewDataViewModel

/**
 * @author D.chuang
 * @date 2020/5/13.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：页面
 */
class LiveDataActivity : AppCompatActivity(){

    lateinit var binding:ActivityLivedataBinding
    private var livedata = MutableLiveData<String>()
    private var testBean: TestBean = TestBean(ObservableField("123"))
    private lateinit var viewmodel : LivewDataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livedata)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_livedata)
        binding.textstr = livedata.value
        binding.dataBsource = testBean

        binding.lifecycleOwner = this
        viewmodel = ViewModelProvider(this)[LivewDataViewModel::class.java]
        binding.liveviewmodel = viewmodel
        livedata.observe(this, Observer<String> { t ->
            binding.textstr = t
            Log.i("tag","=========livedata$t")
        })
        addLiveObserve();
        addTextViewChange()
    }

    fun addTextViewChange(){
        binding.txt.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                Log.i("tag","livedata  数据txt$s")
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })

        binding.txtDataBinding.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                Log.i("tag","livedata  txtDataBinding$s")
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })
    }

    private fun addLiveObserve() {
        livedata.observe(this, Observer<String> { s ->
            binding.textstr = s
            Log.i("观察LiveData", "单独使用LiveData ==> $s")
        })
    }
    override fun onStop() {
        super.onStop()
        livedata.postValue("单独listdata使用")
        testBean.name.set("我是databinding双向绑定")
        viewmodel.getData().postValue("这是使用了life来管理数据")
    }

}