package com.example.cusview.views.capture1_base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cusview.R
import com.example.cusview.base.BaseActivity
import com.example.cusview.databinding.ActivityCaptureOneBinding

class CaptureOneActivity : BaseActivity<ActivityCaptureOneBinding>() {

    override fun initViewBinding(): ActivityCaptureOneBinding {
       return ActivityCaptureOneBinding.inflate(layoutInflater)
    }

    override fun init() {

    }

    override fun initClick() {
    }
}