package com.bcd.wanandroid.easymvvm

import java.io.Serializable

/**
 * @author D.chuang
 * @date 2020/5/14.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：页面
 */
class ResponModel<T> : Serializable {
    private var data: T? = null
    private var errorCode = 0
    private var errorMsg: String? = null
    fun getData(): T? {
        return data
    }

    fun setData(data: T) {
        this.data = data
    }

    fun getErrorCode(): Int {
        return errorCode
    }

    fun setErrorCode(errorCode: Int) {
        this.errorCode = errorCode
    }

    fun getErrorMsg(): String? {
        return errorMsg
    }

    fun setErrorMsg(errorMsg: String?) {
        this.errorMsg = errorMsg
    }

    fun isSuccess(): Boolean {
        return RESULT_SUCCESS == errorCode
    }

    companion object {
        const val RESULT_SUCCESS = 0
    }
}