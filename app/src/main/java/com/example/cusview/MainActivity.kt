package com.example.cusview

import android.content.Intent
import com.example.cusview.base.BaseActivity
import com.example.cusview.databinding.ActivityMainBinding
import com.example.cusview.views.cap1_base.CaptureOneActivity
import com.example.cusview.views.cap2_animation.AnimationActivity
import com.example.cusview.views.cap3_value_animator.PropertyAnimatorActivity

/**
 *@autor sts
 *@date 2023/11/26 14:47
 *@description 自定义控件开发
 *
 */
class MainActivity : BaseActivity<ActivityMainBinding>() {
    // TODO: 将每章的内容在每个activity 中以文档的形式显示出来，方便在demo app中查看

    override fun initViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initData() {
        binding.btCapture1.setOnClickListener {
            Intent(this, CaptureOneActivity::class.java).apply { startActivity(this) }
        }
        binding.btCapture2.setOnClickListener {
            Intent(this, AnimationActivity::class.java).apply { startActivity(this) }
        }
        binding.btCapture3.setOnClickListener {
            Intent(this, PropertyAnimatorActivity::class.java).apply { startActivity(this) }
        }

    }

    override fun definiteTitle() = "自定义View"
    override fun initClick() {

    }
}