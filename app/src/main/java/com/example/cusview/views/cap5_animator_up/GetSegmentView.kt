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
 * date：2023/12/24 21:51
 * description:路径动画
 */
class GetSegmentView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private var mPathMeasure: PathMeasure? = null
    private var mCurAnimValue: Float = 0.0f
    private var mDstPath: Path? = null
    private var mPaint: Paint? = null

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.STROKE
            strokeWidth = 4.0f
            color = Color.BLACK
        }
        mDstPath = Path()
        val mCirclePath = Path().apply {
            addCircle(100.0f, 100.0f, 50.0f, Path.Direction.CW)
        }
        mPathMeasure = PathMeasure(mCirclePath, true)

        ValueAnimator.ofFloat(0f, 1.0f).apply {
            repeatCount = ValueAnimator.INFINITE
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
        val length = mPathMeasure?.length
        val stop = length!! * mCurAnimValue
        val start = (stop - (0.5 - Math.abs(mCurAnimValue - 0.5)) * length).toFloat()
        mDstPath?.reset()
        canvas?.drawColor(Color.WHITE)
        mPathMeasure?.getSegment(start, stop, mDstPath, true)
        canvas?.drawPath(mDstPath!!, mPaint!!)
    }

}