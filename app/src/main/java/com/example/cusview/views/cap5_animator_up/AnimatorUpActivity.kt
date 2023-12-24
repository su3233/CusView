package com.example.cusview.views.cap5_animator_up

import com.example.cusview.base.BaseActivity
import com.example.cusview.databinding.ActivityAnimatorUpBinding

/**
 *@author crete by sutongsheng
 * date：2023/12/24 17:29
 * description:PathMeasure（路径动画）和svg动画
 */
class AnimatorUpActivity : BaseActivity<ActivityAnimatorUpBinding>() {
    override fun definiteTitle() = "动画进阶"

    override fun initViewBinding() = ActivityAnimatorUpBinding.inflate(layoutInflater)

    override fun initClick() {
        binding.btAnimatorUpStart.setOnClickListener {

        }
    }
    override fun initData() {
    }



}