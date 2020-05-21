package com.bcd.wanandroid.easymvvm

import java.io.Serializable

/**
 * @author D.chuang
 * @date 2020/5/14.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：页面
 */
data class BannerBean(
        var desc:String,
        var id:Int,
        var imagePath:String,
        var isVisible:Int,
        var order:Int,
        var title:String,
        var type:Int,
        var url:String):Serializable{
}