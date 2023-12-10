package com.example.cusview.views.cap3_value_animator

import android.animation.Animator
import android.animation.ArgbEvaluator
import android.animation.TypeEvaluator
import android.animation.ValueAnimator
import android.renderscript.Sampler.Value
import android.util.Log
import android.view.animation.AccelerateDecelerateInterpolator
import com.example.cusview.base.BaseActivity
import com.example.cusview.databinding.ActivityValueAnimatorBinding

/**
 *@author crete by sutongsheng
 * date：2023/12/10 11:01
 * description: 属性动画包括valueAnimator和ObjectAnimator
 */
class PropertyAnimatorActivity : BaseActivity<ActivityValueAnimatorBinding>() {
    private var valueAnim: ValueAnimator? = null
    override fun initViewBinding() = ActivityValueAnimatorBinding.inflate(layoutInflater)

    override fun initData() {
        /**
         * Evaluator用于将插值器返回的值转换为对应的数值
         */

    }

    override fun initClick() {
        binding.tvValueAnim.setOnClickListener {
            toast("我被点击了")
        }
        /**
         * valueAnimation不直接对控件进行操作，而是通过监听值的改变，改变view
         */
        binding.btStart.setOnClickListener {
            valueAnim = ValueAnimator.ofInt(0, 100, 300, 100).apply {
                duration = 1000
//                repeatCount = ValueAnimator.INFINITE
//                repeatMode = ValueAnimator.REVERSE
                addUpdateListener {
                    Log.i(TAG, "initClick: ${it.animatedValue}")
                    val curValue = it.animatedValue as Int
                    binding.tvValueAnim.layout(
                        curValue,
                        curValue,
                        curValue + binding.tvValueAnim.width,
                        curValue + binding.tvValueAnim.height
                    )
                }
//                interpolator = AccelerateDecelerateInterpolator()
                addListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(p0: Animator) {
                        Log.i(TAG, "onAnimationStart: ")
                    }

                    override fun onAnimationEnd(p0: Animator) {
                        Log.i(TAG, "onAnimationEnd: ")
                    }

                    override fun onAnimationCancel(p0: Animator) {
                        Log.i(TAG, "onAnimationCancel: ")
                    }

                    override fun onAnimationRepeat(p0: Animator) {
                        Log.i(TAG, "onAnimationRepeat: ")
                    }

                })
                start()
            }

            /**
             * color
             */
            ValueAnimator.ofInt(0xffffff00.toInt(), 0xff0000ff.toInt()).apply {
                setEvaluator(ArgbEvaluator())
                duration = 1000
                addUpdateListener {
                    val color = it.animatedValue as Int
                    binding.tvValueAnim.setBackgroundColor(color)
                }
                start()
            }
            /**
             * ValueAnimator接收一个对象，通过对象中的数值变化转变为view属性变化
             */
            ValueAnimator.ofObject(CharEvaluator(), Character('A'), Character('Z')).apply {
                duration = 3000
                addUpdateListener {
                    val char = it.animatedValue as Character
                    binding.tvValueAnim.text = "$char"
                }
                start()
            }
        }
        binding.btStop.setOnClickListener {
            valueAnim?.cancel()
            valueAnim?.removeAllListeners()
        }

    }

    override fun definiteTitle() = "属性动画"

}

class CharEvaluator : TypeEvaluator<Character> {
    override fun evaluate(p0: Float, p1: Character?, p2: Character?): Character {
        p1?.let { it1 ->
            p2?.let { it2 ->
                val start = it1.charValue().code
                val end = it2.charValue().code
                val result = (start + p0 * (end - start)).toInt()
                return result.toChar() as Character
            }
        }
        return Character('R')
    }

}