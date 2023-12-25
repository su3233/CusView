package com.example.cusview.views.cap5_animator_up

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PathMeasure
import android.util.AttributeSet
import android.view.View

/**
 *@author crete by sutongsheng
 * date：2023/12/26 00:14
 * description:
 */
class MyAliPayView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private var mPathMeasure: PathMeasure? = null
    private var mCurAnimValue: Float = 0.0f
    private var mDstPath: Path? = null
    private var mPaint: Paint? = null
    private var mCenterX: Float = 100.0f
    private var mCenterY: Float =1000.0f
    private var mRadius: Float = 50.0f
    private var mCirclePath: Path? = null
    private var mNext = false

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.STROKE
            strokeWidth = 4.0f
            color = Color.BLACK
        }
        mDstPath = Path()
        mCirclePath = Path().apply {
            addCircle(mCenterX, mCenterY, mRadius, Path.Direction.CW)
            moveTo(mCenterX - mRadius / 2, mCenterY)
            lineTo(mCenterX, mCenterY + mRadius / 2)
            lineTo(mCenterX + mRadius / 2, mCenterY - mRadius / 3)
        }
        mPathMeasure = PathMeasure(mCirclePath, false)
        ValueAnimator.ofFloat(0f, 2.0f).apply {
            addUpdateListener {
                mCurAnimValue = it.animatedValue as Float
                invalidate()
            }
            duration = 2000
            start()
        }

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.LTGRAY)
        if (mCurAnimValue < 1) {
            val stop = mPathMeasure?.length?.times(mCurAnimValue)
            mPathMeasure?.getSegment(0f, stop!!, mDstPath, true)
        } else {
            if (!mNext) {
                mNext = true
                mPathMeasure?.getSegment(0f, mPathMeasure?.length!!, mDstPath, true)
                mPathMeasure?.nextContour()
            }
            val stop = mPathMeasure?.length?.times(mCurAnimValue - 1)
            mPathMeasure?.getSegment(0f, stop!!, mDstPath, true)
        }
        canvas?.drawPath(mDstPath!!, mPaint!!)
    }
}