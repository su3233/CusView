package com.example.cusview.views.cap6_paint_basic

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

/**
 *@author crete by sutongsheng
 * date：2023/12/28 23:57
 * description:画文字
 */
class PaintText(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val baseLineX = 0.0f
    private val baseLineY = 200.0f
    private val paint = Paint().apply {
        style = Paint.Style.FILL
        color = Color.RED
        textSize = 120.0f
    }

    init {

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        /**
         * x为相对矩形的位置，y为基线
         */
        paint.textAlign = Paint.Align.CENTER
        val text = "harvic's blog"
        canvas?.drawText(text, baseLineX, baseLineY, paint)
        /**
         * 获取文字的包裹矩形
         */
        paint.getTextBounds("harvic's blog", 0, text.length, Rect())
    }
}