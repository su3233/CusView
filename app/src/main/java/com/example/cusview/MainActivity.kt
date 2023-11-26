package com.example.cusview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.example.cusview.base.BaseActivity
import com.example.cusview.databinding.ActivityMainBinding
import com.example.cusview.views.capture1_base.CaptureOneActivity
import com.example.cusview.views.capture2_animation.AnimationActivity

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

    override fun init() {
        setTitle("自定义控件开发")
        binding.btCapture1.setOnClickListener {
            Intent(this, CaptureOneActivity::class.java).apply { startActivity(this) }
        }
        binding.btCapture2.setOnClickListener {
            Intent(this, AnimationActivity::class.java).apply { startActivity(this) }
        }
    }

    override fun initClick() {

    }
}