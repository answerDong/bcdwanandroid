package com.bcd.wanandroid.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.bcd.wanandroid.R
import kotlinx.android.synthetic.main.fragment_progress_dialog.*
/**
 * @author D.chuang
 * @date 2020/5/8.
 * gitee：https://gitee.com/gaoerdongchuang/fycz_new
 * email：gaoerdongchuang@163.com
 * description：页面
 */
class ProgressDialogFragment : DialogFragment(){

    private var messageResId: Int? = null

    companion object{
        fun newInstance() = ProgressDialogFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_progress_dialog,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvMessage.text = getString(messageResId ?: R.string.loading)

    }

    fun show(
        fragmentManager: FragmentManager,
        messageResId : Int,
        isCancelable : Boolean = false
    ){
        this.messageResId = messageResId
        this.isCancelable = isCancelable
        show(fragmentManager, "progressDialogFragment")
    }
}