package com.example.cusview.views.capture1_base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cusview.R
import com.example.cusview.base.BaseActivity
import com.example.cusview.databinding.ActivityCaptureOneBinding

/**
 *@autor sts
 *@date 2023/11/26 14:42
 *@description 绘画基础，paint，path、rect、canvas
 */
class CaptureOneActivity : BaseActivity<ActivityCaptureOneBinding>() {

    override fun initViewBinding(): ActivityCaptureOneBinding {
        return ActivityCaptureOneBinding.inflate(layoutInflater)
    }

    override fun init() {
        setTitle("绘画基础")
    }

    override fun initClick() {
    }
}