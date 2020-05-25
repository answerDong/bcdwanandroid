package com.bcd.wanandroid.mvvmdemo.model.data

/**
 * @author D.chuang
 * @date 2020/5/25.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：页面
 */
data class Article(
    var id: Int = 0,
    var title: String?,
    var readme: String?,
    var describe: String?,
    var click: Int = 0,
    var channel: Int = 0,
    var comments: Int = 0,
    var stow: Int = 0,
    var upvote: Int = 0,
    var downvote: Int = 0,
    var url: String?,
    var pubDate: String?,
    var thumbnail: String?) {
    var content: String? = null
}