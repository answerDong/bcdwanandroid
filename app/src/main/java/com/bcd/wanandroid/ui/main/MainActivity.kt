package com.bcd.wanandroid.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bcd.wanandroid.R
import com.bcd.wanandroid.utils.core.ActivityManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("TAG","========activities"+ActivityManager.getActivitiesSize())
    }
}
