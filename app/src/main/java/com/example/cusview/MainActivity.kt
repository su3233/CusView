package com.example.cusview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.example.cusview.base.BaseActivity
import com.example.cusview.databinding.ActivityMainBinding
import com.example.cusview.views.capture1_base.CaptureOneActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun initViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun init() {
        binding.btCapture1.setOnClickListener {
            Intent(this, CaptureOneActivity::class.java).apply { startActivity(this) }
        }
    }

    override fun initClick() {

    }
}