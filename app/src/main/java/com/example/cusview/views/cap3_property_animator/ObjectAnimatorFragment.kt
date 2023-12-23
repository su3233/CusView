package com.example.cusview.views.cap3_property_animator

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.LayoutInflater
import android.widget.Button
import androidx.core.view.isVisible
import com.example.cusview.R
import com.example.cusview.base.BaseFragment
import com.example.cusview.databinding.FragmentObjectAnimatiorBinding
import kotlin.math.cos
import kotlin.math.sin

/**
 *ObjectAnimator：通过调用view对象的属性方法（setScaleX）实现对view的动画
 * 插值器，估值器
 */
class ObjectAnimatorFragment : BaseFragment<FragmentObjectAnimatiorBinding>() {
    private var animatorSet: AnimatorSet? = null
    private var mIsMenuOpen = false
    override fun initData() {

    }

    override fun initViewBinding(inflater: LayoutInflater): FragmentObjectAnimatiorBinding {
        return FragmentObjectAnimatiorBinding.inflate(layoutInflater)
    }

    override fun initView() {

    }

    override fun initClick() {
//        xmlAnimator()
        xmlObjectAnim()
        binding.tvObject.setOnClickListener {
            toast("click")
        }
        /**
         * AnimatorSet函数中设置的插值器和时间等，会覆盖掉单个动画中的设置
         */
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
//            AnimatorSet().apply {
//                playSequentially(
//                    backgroundAnimator,
//                    scaleAnimator,
//                    translateAnimation,
//                    alphaAnimator
//                )
//                duration = 3000
//                start()
//            }

            /**
             * AnimatorSet.Builder
             * 可是实现播放完A动画后同时播放B和C动画
             */
            animatorSet = AnimatorSet().apply {
                addListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(p0: Animator) {

                    }

                    override fun onAnimationEnd(p0: Animator) {
                    }

                    override fun onAnimationCancel(p0: Animator) {
                    }

                    override fun onAnimationRepeat(p0: Animator) {
                    }

                })
                play(scaleAnimator).with(alphaAnimator).after(translateAnimation)
                duration = 2000
                start()
            }

        }
        binding.btObjectEnd.setOnClickListener {
            animatorSet?.cancel()
        }
        /**
         * 路径动画，点击会有扇形展开菜单
         */
        binding.animPathMenu.menu.setOnClickListener {
            toast("menu")
            if (!mIsMenuOpen) {
                mIsMenuOpen = true
                openMenu()
            } else {
                mIsMenuOpen = false
                closeMenu()
            }
        }
    }

    /**
     * xml实现属性动画
     */
    private fun xmlObjectAnim() {
        (AnimatorInflater.loadAnimator(
            context,
            R.animator.xml_object_anim
        ) as ObjectAnimator).apply {
            target = binding.tvObject
            start()
        }

    }

    /**
     * xml实现animator
     */
    private fun xmlAnimator() {
        (AnimatorInflater.loadAnimator(context, R.animator.xml_animator) as ValueAnimator).apply {
            addUpdateListener {
                val offset = (it.animatedValue as Float).toInt()
                binding.tvObject.layout(
                    offset,
                    offset,
                    binding.tvObject.width + offset,
                    binding.tvObject.height + offset
                )
            }
            start()
        }

    }

    private fun closeMenu() {
        doAnimateClose(binding.animPathMenu.item1, 0, 5, 500)
        doAnimateClose(binding.animPathMenu.item2, 1, 5, 500)
        doAnimateClose(binding.animPathMenu.item3, 2, 5, 500)
        doAnimateClose(binding.animPathMenu.item4, 3, 5, 500)
        doAnimateClose(binding.animPathMenu.item5, 4, 5, 500)

    }

    private fun doAnimateClose(button: Button, index: Int, total: Int, radius: Int) {
//        if (button.isVisible.not()) {
//            button.isVisible = true
//        }
        val degree = Math.PI * index / ((total - 1)) * 2
        val translationX = -(radius * sin(degree)).toFloat()
        val translationY = -(radius * cos(degree)).toFloat()
        AnimatorSet().apply {
            playTogether(
                ObjectAnimator.ofFloat(button, "translationX", translationX, 0f),
                ObjectAnimator.ofFloat(button, "translationY", translationY, 0f),
                ObjectAnimator.ofFloat(button, "scaleX", 1f, 0f),
                ObjectAnimator.ofFloat(button, "scaleY", 1f, 0f),
                ObjectAnimator.ofFloat(button, "alpha", 1f, 0f)
            )
            addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(p0: Animator) {

                }

                override fun onAnimationEnd(p0: Animator) {
                    button.isVisible = false

                }

                override fun onAnimationCancel(p0: Animator) {
                }

                override fun onAnimationRepeat(p0: Animator) {
                }

            })
            duration = 500
            start()
        }

    }

    private fun openMenu() {
        doAnimateOpen(binding.animPathMenu.item1, 0, 5, 500)
        doAnimateOpen(binding.animPathMenu.item2, 1, 5, 500)
        doAnimateOpen(binding.animPathMenu.item3, 2, 5, 500)
        doAnimateOpen(binding.animPathMenu.item4, 3, 5, 500)
        doAnimateOpen(binding.animPathMenu.item5, 4, 5, 500)

    }

    private fun doAnimateOpen(button: Button, index: Int, total: Int, radius: Int) {
        if (button.isVisible.not()) {
            button.isVisible = true
        }
        val degree = Math.toRadians(90.0) / (total - 1) * index
        val translationX = -(radius * sin(degree)).toFloat()
        val translationY = -(radius * cos(degree)).toFloat()
        AnimatorSet().apply {
            playTogether(
                ObjectAnimator.ofFloat(button, "translationX", 0f, translationX),
                ObjectAnimator.ofFloat(button, "translationY", 0f, translationY),
                ObjectAnimator.ofFloat(button, "scaleX", 0f, 1f),
                ObjectAnimator.ofFloat(button, "scaleY", 0f, 1f),
                ObjectAnimator.ofFloat(button, "alpha", 0f, 1f)
            )
            duration = 500
            start()
        }
    }

}