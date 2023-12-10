package com.example.cusview.views.cap1_base

import com.example.cusview.base.BaseActivity
import com.example.cusview.databinding.ActivityCaptureOneBinding

/**
 *@autor sts
 *@date 2023/11/26 14:42
 *@description 绘画基础，paint，path、rect、canvas
 */
class CaptureOneActivity : BaseActivity<ActivityCaptureOneBinding>() {

    override fun initViewBinding() = ActivityCaptureOneBinding.inflate(layoutInflater)

    override fun definiteTitle() = "动画基础"


    override fun initData() {
    }

    override fun initClick() {
    }
}