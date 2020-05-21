package com.bcd.wanandroid.easymvvm

import android.app.Activity
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.*
import com.bcd.wanandroid.R
import kotlinx.android.synthetic.main.activity_livedata.*
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


/**
 * @author D.chuang
 * @date 2020/5/14.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：页面
 */
class TestActivity : Activity(),LifecycleOwner{
    private var livedata = MutableLiveData<String>()
    var lifecycle = LifecycleRegistry(this)
    var observer = MyObserver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livedata)
        lifecycle.addObserver(observer)
        livedata.observe(this,Observer<String>{
            Log.i("tag","===========或得到的结果$it")
        })
        button.setOnClickListener{
            Thread(Runnable {
//                var url = URL("https:/www.taobao.com/")
//                val uc: URLConnection = url.openConnection() // 生成连接对象
//                uc.connect() // 发出连接
////                uc.connectTimeout = 5000
//                //                    uc.readTimeout = 5000
//                val ld = uc.date // 取得网站日期时间
//                Log.i("tag", "==============ldtime$ld")
                val url = URL("https:/www.taobao.com/")
                // 打开一个HttpURLConnection连接
                // 打开一个HttpURLConnection连接
                val urlConn: HttpURLConnection = url.openConnection() as HttpURLConnection
                // 设置连接主机超时时间
                // 设置连接主机超时时间
                urlConn.connectTimeout = 5 * 1000
                //设置从主机读取数据超时
                //设置从主机读取数据超时
                urlConn.readTimeout = 5 * 1000
                // 设置是否使用缓存  默认是true
                // 设置是否使用缓存  默认是true
                urlConn.useCaches = true
                // 设置为Post请求
                // 设置为Post请求
                urlConn.requestMethod = "GET"

                //urlConn设置请求头信息
                //设置请求中的媒体类型信息。
                //urlConn设置请求头信息
                //设置请求中的媒体类型信息。
//                urlConn.setRequestProperty("Cache-Control", "private");
//                urlConn.setRequestProperty("If-Modified-Since","Wed, 08 Sep 2010 21:35:06 GMT")
                urlConn.setRequestProperty("Content-Type", "application/json")
                //设置客户端与服务连接类型
                //设置客户端与服务连接类型
                urlConn.addRequestProperty("Connection", "Keep-Alive")
                // 开始连接
                // 开始连接

                // 判断请求是否成功
                // 判断请求是否成功
                var map: Map<String,List<String>> = urlConn.headerFields
                for ((key, value) in map) {
                    Log.e(TAG, "Get方式请求成功，result--->$key   $value")
//                        if(key == "Date"){
//                            Log.e(TAG, "Get方式请求成功，result--->$key   $value")
//                        }
                }
                Log.e(TAG, "Get方式请求成功，result--->${urlConn.date}")
                if (urlConn.responseCode == 200) {
                    urlConn.connect()
                    Log.e(TAG, "Get方式请求成功，result--->$urlConn.responseCode")
                    // 获取返回的数据
//                    val result: String = streamToString(urlConn.getInputStream())
//                    Log.e(TAG, "Get方式请求成功，result--->$result")
                }  else  {
//                    val result: String = streamToString(urlConn.getInputStream())
//                    Log.e(TAG, "Get方式请求成功，result--->$urlConn.responseCode")
//                    Log.e(TAG, "Get方式请求失败")
                }
                // 关闭连接
                // 关闭连接
                urlConn.disconnect()
            }).start()
        }
    }

    fun streamToString(inputStream: InputStream): String {
        return try {
            val baos = ByteArrayOutputStream()
            val buffer = ByteArray(1024)
            var len = 0
            while (inputStream.read(buffer).also { len = it } != -1) {
                baos.write(buffer, 0, len)
            }
            baos.close()
            inputStream.close()
            val byteArray: ByteArray = baos.toByteArray()
            String(byteArray)
        } catch (e: Exception) {
            Log.e(TAG, e.toString())
            ""
        }
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycle
//        return null
    }

    override fun onSaveInstanceState(outState: Bundle) {
        lifecycle.currentState = Lifecycle.State.CREATED
        super.onSaveInstanceState(outState)

    }

    override fun onStop() {
        super.onStop()
        livedata.postValue("这个值")
    }

}