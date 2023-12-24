package com.example.cusview.views.cap4_property_up

import android.animation.Animator
import android.animation.Keyframe
import android.animation.LayoutTransition
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Button
import com.example.cusview.base.BaseActivity
import com.example.cusview.databinding.ActivityPropertyUpBinding

/**
 *@author crete by sutongsheng
 * date：2023/12/23 15:46
 * description:属性动画进阶
 * Keyframe关键帧：控制动画播放速率
 * ObjectAnimator和PropertyValuesHolder、ViewPropertyAnimator都可实现动画：ViewPropertyAnimator都可实现动画是简洁版
 */
class PropertyAnimUpActivity : BaseActivity<ActivityPropertyUpBinding>() {
    override fun initViewBinding() = ActivityPropertyUpBinding.inflate(layoutInflater)
    override fun initData() {

    }

    override fun initClick() {
        initViewGroupAnimator()
        binding.tvProUp.setOnClickListener {
            toast("click")
        }
        binding.btPropertyUpStart.setOnClickListener {
            /**
             * 使用Keyframe定义动画关键位置的值,两个Keyframe之间可使用插值器
             */
            val frameHolder = PropertyValuesHolder.ofKeyframe(
                "rotation",
                Keyframe.ofFloat(0f, 0f),
                Keyframe.ofFloat(0.1f, -20f),
                Keyframe.ofFloat(1f, 0f)
            )
            ObjectAnimator.ofPropertyValuesHolder(binding.tvProUp, frameHolder).apply {
                duration = 2000
                start()
            }

            /**
             * 使用Keyframe实现电话震动效果,
             * ofPropertyValuesHolder可接收多个PropertyValuesHolder实现边震动边放大，实现AnimationSet效果
             */
            val callHolder = PropertyValuesHolder.ofKeyframe(
                "rotation",
                Keyframe.ofFloat(0f, 20f),
                Keyframe.ofFloat(0.1f, -20f),
                Keyframe.ofFloat(0.2f, 20f),
                Keyframe.ofFloat(0.3f, -20f),
                Keyframe.ofFloat(0.4f, 20f),
                Keyframe.ofFloat(0.5f, -20f),
                Keyframe.ofFloat(0.6f, 20f),
                Keyframe.ofFloat(0.7f, -20f),
                Keyframe.ofFloat(0.8f, 20f),
                Keyframe.ofFloat(0.9f, -20f),
                Keyframe.ofFloat(1f, 0f),
            )
            ObjectAnimator.ofPropertyValuesHolder(binding.ivCallComeon, callHolder).apply {
                interpolator = AccelerateDecelerateInterpolator()
                duration = 1000
//                repeatCount = ObjectAnimator.INFINITE
                repeatCount = 10
                repeatMode = ValueAnimator.RESTART
                start()
            }
            /**
             * 每一个操作返回ViewPropertyAnimator，更快捷的属性动画实现
             */
            binding.tvProUp.animate().alpha(0.5f).x(300f).scaleX(2f)
        }

    }


    /**
     * 为viewGroup内的组件实现动画（如list的item的加载、添加、删除），4中方法：
     * layoutAnimation
     * gridLayoutAnimation
     * android:layoutAnimateChanges
     * LayoutTransition
     */
    private var index = 0

    @SuppressLint("ObjectAnimatorBinding")
    private fun initViewGroupAnimator() {
        /**
         * 使用LayoutTranslation，当出现和删除时的动画
         */
        LayoutTransition().apply {
            setAnimator(
                LayoutTransition.APPEARING,
                ObjectAnimator.ofFloat(null, "rotationY", 0f, 360f, 0f)
            )
            /**当出现或者删除时，其他view的动画
             * LayoutTransition.CHANGE_APPEARING需要结合PropertyValuesHolder使用
             */
//            PropertyValuesHolder.ofInt("left",0,0)
//            PropertyValuesHolder.ofInt("top",0,0)
            setAnimator(
                LayoutTransition.DISAPPEARING,
                ObjectAnimator.ofFloat(null, "rotation", 0f, 90f, 0f)
            )
            addTransitionListener(object : LayoutTransition.TransitionListener {
                override fun startTransition(
                    p0: LayoutTransition?,
                    p1: ViewGroup?,
                    p2: View?,
                    p3: Int
                ) {
                    Log.i(TAG, "startTransition: ")
                }

                override fun endTransition(
                    p0: LayoutTransition?,
                    p1: ViewGroup?,
                    p2: View?,
                    p3: Int
                ) {
                    Log.i(TAG, "endTransition: ")
                }

            })
            binding.llViewGroupAnim.layoutTransition = this
        }
        binding.btAdd.setOnClickListener {
            index++
            binding.llViewGroupAnim.addView(
                Button(this).apply {
                    text = "button_${index}"
                },
                ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            )
        }
        binding.btRemove.setOnClickListener {
            if (index > 0) {
                binding.llViewGroupAnim.removeViewAt(0)
                index--
            }
            toast("index:$index")
        }


    }

    override fun definiteTitle() = "属性动画进阶"


}