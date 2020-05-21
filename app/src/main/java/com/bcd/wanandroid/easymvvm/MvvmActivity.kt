//package com.bcd.wanandroid.easymvvm
//
//import android.app.Activity
//import androidx.databinding.DataBindingUtil
//import androidx.lifecycle.Observer
//import com.bcd.wanandroid.GlideImageLoader
//import com.bcd.wanandroid.R
//import com.bcd.wanandroid.databinding.ActivityMvvmBinding
//import com.youth.banner.BannerConfig
//import com.youth.banner.loader.ImageLoader
//
///**
// * @author D.chuang
// * @date 2020/5/14.
// * gitee：https://gitee.com/gaoerdongchuang/fycz_new
// * email：gaoerdongchuang@163.com
// * description：页面
// */
//class MvvmActivity : BaseActivity<MainViewModel>() {
//    var binding = ActivityMvvmBinding()
//    override fun getContentViewId(): Int {
//        return R.layout.activity_mvvm
//    }
//
//    override fun getActivity(): Activity {
//        return this@MvvmActivity
//    }
//
//    override fun createbinding() {
//        binding = DataBindingUtil.setContentView(this,R.layout.activity_mvvm)
////        //给binding加上感知生命周期，AppCompatActivity就是lifeOwner，之前解释过了，不懂看前面
//        binding?.lifecycleOwner = this
//    }
//
//    override fun processLogic() {
//
//        initBanners()
//        binding?.btn?.setOnClickListener {
//            getBanner()
//       }
//    }
//
//    private fun initBanners() {
//        binding?.banner?.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
//        //这是给banner添加图片加载器
//        var glideloader = GlideImageLoader()
//        binding?.banner?.setImageLoader(glideloader as ImageLoader)
//
//    }
//
//    fun getBanner() {
//        mViewModel?.getBanners()?.observe(this, Observer {
//            updateBanner(it)
//        })
//    }
//
//    fun updateBanner( data : List<BannerBean> ) {
//        if (data == null || data.isEmpty()) {
//            return;
//        }
//        var urls = ArrayList<String>()
//        var titles = ArrayList<String>()
//        var iterator = data.listIterator()
//        for(i in iterator){
//            urls.add(i.imagePath)
//            titles.add(i.title)
//        }
//        binding!!.banner.setBannerTitles(titles);
//        binding!!.banner.setImages(urls);
//        binding!!.banner.start();
//    }
//
//
//
//}