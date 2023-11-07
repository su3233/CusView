package com.example.cusview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.example.cusview.base.BaseActivity
import com.example.cusview.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun initViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun init() {
        binding.tvMain.setOnClickListener {
            toast("click")
        }
    }

    override fun initClick() {

    }
}