package com.example.cusview.views.cap6_paint_basic

import com.example.cusview.base.BaseActivity
import com.example.cusview.databinding.ActivityPaintBasicBinding

/**
 *@author crete by sutongsheng
 * date：2023/12/24 17:40
 * description:
 */
class PaintBasicActivity : BaseActivity<ActivityPaintBasicBinding>() {
    override fun definiteTitle() = "Paint的基本使用"

    override fun initClick() {

    }

    override fun initViewBinding() = ActivityPaintBasicBinding.inflate(layoutInflater)

    override fun initData() {
    }

}