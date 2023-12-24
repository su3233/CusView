package com.example.cusview.views.cap5_animator_up

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PathMeasure
import android.util.AttributeSet
import android.view.View
import com.example.cusview.R

/**
 *@author crete by sutongsheng
 * date：2023/12/24 22:17
 * description:正切，反正切实现旋转的箭头始终在半径的切线上
 */
class GetPosTanView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private var mCurAnimValue: Float = 0.0f
    private var mDstPath: Path? = null
    private var mPaint: Paint? = null
    private var mPathMeasure: PathMeasure? = null
    private var mArrowBmp: Bitmap? = null
    private var pos: FloatArray = FloatArray(2)
    private var tan: FloatArray = FloatArray(2)

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        mArrowBmp = BitmapFactory.decodeResource(resources, R.drawable.arrow_right)
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.STROKE
            strokeWidth = 4.0f
            color = Color.BLACK
        }
        mDstPath = Path()
        val mCirclePath = Path().apply {
            addCircle(130.0f, 130.0f, 100.0f, Path.Direction.CW)
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
        /**
         * 箭头
         */
        mPathMeasure?.getPosTan(stop, pos, tan)
        val degrees =
            (Math.atan2(tan[1].toDouble(), tan[0].toDouble()) * 180.0f / Math.PI).toFloat()
        val mMatrix = Matrix().apply {
            postRotate(
                degrees,
                (mArrowBmp!!.width / 2).toFloat(),
                (mArrowBmp!!.height / 2).toFloat()
            )
            postTranslate(
                pos[0] - (mArrowBmp!!.width / 2).toFloat(),
                pos[1] - (mArrowBmp!!.height / 2).toFloat()
            )
        }
        canvas?.drawBitmap(mArrowBmp!!, mMatrix, mPaint)
    }
}