package com.example.cusview.views.cap5_animator_up

import android.graphics.drawable.Animatable
import android.os.Build
import android.view.View.OnFocusChangeListener
import androidx.annotation.RequiresApi
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.example.cusview.R
import com.example.cusview.base.BaseActivity
import com.example.cusview.databinding.ActivityAnimatorUpBinding

/**
 *@author crete by sutongsheng
 * date：2023/12/24 17:29
 * description:PathMeasure（路径动画）和svg动画
 * svg设计软件：Illustrator http://editor.method.ac/
 */
class AnimatorUpActivity : BaseActivity<ActivityAnimatorUpBinding>() {
    override fun definiteTitle() = "动画进阶"

    override fun initViewBinding() = ActivityAnimatorUpBinding.inflate(layoutInflater)

    @RequiresApi(Build.VERSION_CODES.O)
    override fun initClick() {
        binding.btAnimatorUpStart.setOnClickListener {

        }
        with(binding.animImg) {
            isFocusable = true
            isFocusableInTouchMode = true
            requestFocus()
            requestFocusFromTouch()
        }
        binding.edit.onFocusChangeListener = OnFocusChangeListener { p0, p1 ->
            if (p1) {
                AnimatedVectorDrawableCompat.create(this, R.drawable.animated_vecotr_search).apply {
                    binding.animImg.setImageDrawable(this)
                    (binding.animImg.drawable as Animatable).start()
                }
            }
        }
    }

    override fun initData() {
    }


}