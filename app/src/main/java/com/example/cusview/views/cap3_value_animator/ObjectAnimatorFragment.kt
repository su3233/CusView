package com.example.cusview.views.cap3_value_animator

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.LayoutInflater
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.example.cusview.base.BaseFragment
import com.example.cusview.databinding.FragmentObjectAnimatiorBinding

/**
 *ObjectAnimator：通过调用view对象的属性方法（setScaleX）实现对view的动画
 * 插值器，估值器
 */
class ObjectAnimatorFragment : BaseFragment<FragmentObjectAnimatiorBinding>() {
    override fun initData() {

    }

    override fun initViewBinding(inflater: LayoutInflater): FragmentObjectAnimatiorBinding {
        return FragmentObjectAnimatiorBinding.inflate(layoutInflater)
    }

    override fun initView() {

    }

    override fun initClick() {
        binding.btObjectStart.setOnClickListener {
            val alphaAnimator =
                ObjectAnimator.ofFloat(binding.tvObject, "alpha", 1.0f, 0f, 1.0f).apply {
                    duration = 2000
//                start()
                }

            val rotateAnimation =
                ObjectAnimator.ofFloat(binding.tvObject, "rotationX", 0f, 180f, 0f).apply {
                    duration = 2000
//                start()
                }

            val translateAnimation =
                ObjectAnimator.ofFloat(binding.tvObject, "translationX", 0f, 180f, 0f).apply {
                    duration = 2000
//                start()
                }

            val scaleAnimator =
                ObjectAnimator.ofFloat(binding.tvObject, "scaleX", 0f, 3f, 1f).apply {
                    duration = 2000
//                start()
                }

            val backgroundAnimator = ObjectAnimator.ofInt(
                binding.tvObject,
                "backgroundColor",
                0xffff00ff.toInt(),
                0xffffff00.toInt(),
                0xffff00ff.toInt()
            )

            /**
             * AnimatorSet：依次播放，一起播放
             */
            AnimatorSet().apply {
                playSequentially(
                    backgroundAnimator,
                    scaleAnimator,
                    translateAnimation,
                    alphaAnimator
                )
                duration = 3000
                start()
            }

        }
    }

}