package com.example.cusview.views.cap2_animation

import android.graphics.drawable.AnimationDrawable
import android.util.Log
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.view.animation.AnticipateInterpolator
import android.view.animation.AnticipateOvershootInterpolator
import android.view.animation.BounceInterpolator
import android.view.animation.CycleInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.view.animation.OvershootInterpolator
import android.view.animation.RotateAnimation
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import com.example.cusview.R
import com.example.cusview.base.BaseActivity
import com.example.cusview.databinding.ActivityAnimationctivityBinding

/**
 *@autor sts
 *@date 2023/11/26 14:42
 *@description 动画
 * android动画分为view动画（又分为tween动画<补间动画>和frame动画<帧动画>）和property动画（又分为value动画和object动画）
 * view动画只是视图的变换，原位置的点击事件还是会触发，新位置的点击事件不触发
 */
class AnimationActivity : BaseActivity<ActivityAnimationctivityBinding>() {
    override fun initViewBinding() = ActivityAnimationctivityBinding.inflate(layoutInflater)
    override fun definiteTitle() = "view动画"

    override fun initData() {
        /**
         * 动画类型分为alpha、scale、translate、rotate、set（动画集）
         */

        /**
         * 线性插值器：匀速
         */
        LinearInterpolator()
        /**
         * 开始和结束比较慢，中间比较快
         */
        AccelerateDecelerateInterpolator()
        /**
         * 加速插值器：开始比较慢，然后变快
         */
        AccelerateInterpolator()
        /**
         *减速插值器：速度逐渐变慢
         */
        DecelerateInterpolator()
        /**
         * 弹跳插值器:类似弹球，会回退一下
         */
        BounceInterpolator()
        /**
         * 初始值偏移插值器：开始时会向前偏移一段距离,如translate动画会先反向移动一段距离，tension越大偏移距离越大，默认是2
         */
        AnticipateInterpolator(4F)
        /**
         * 结束偏移插值器:动画结束时会惯性继续向前进行一段距离
         */
        OvershootInterpolator(4f)
        /**
         * 两个插值器的结合，开始会向前进行一段，结束会向后进行一段
         */
        AnticipateOvershootInterpolator(3f)
        /**
         * 循环插值器：速度以正弦变化,2为循环次数
         */
        CycleInterpolator(2f)
    }

    override fun initClick() {
        binding.tvAnimTarget.setOnClickListener {
            toast("click")
        }
        binding.btScaleAnim.setOnClickListener {
            /**
             * 代码实现
             */
            ScaleAnimation(
                0.0f,
                1.4f,
                0.0f,
                1.4f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
            ).apply {
                this.duration = 800
                repeatCount = 3
                /**
                 * 插值器
                 */
                interpolator = LinearInterpolator()
                repeatMode = Animation.REVERSE
                //设置动画监听
                setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(p0: Animation?) {
                        Log.i(TAG, "onAnimationStart: ")
                    }

                    override fun onAnimationEnd(p0: Animation?) {
                        Log.i(TAG, "onAnimationEnd: ")
                        AlphaAnimation(1.0f, 0.0f).apply {
                            duration = 3000
                            binding.tvAnimTarget.startAnimation(this)
                        }
                    }

                    override fun onAnimationRepeat(p0: Animation?) {
                        Log.i(TAG, "onAnimationRepeat: ")
                    }

                })
                binding.tvAnimTarget.startAnimation(this)
            }
            /**
             * 加载xml动画
             */
//            AnimationUtils.loadAnimation(this, R.anim.scale_anim).apply {
//                binding.tvAnimTarget.startAnimation(this)
//            }
        }
        binding.btAlphaAnim.setOnClickListener {
            AlphaAnimation(0.0f, 2.0f).apply {
                this.duration = 800
                binding.tvAnimTarget.startAnimation(this)
            }
//            AnimationUtils.loadAnimation(this, R.anim.alpha_anim).apply {
//                binding.tvAnimTarget.startAnimation(this)
//            }
        }
        binding.btRoateAnim.setOnClickListener {
            RotateAnimation(
                0.0f, 90.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
            ).apply {
                duration = 800
                binding.tvAnimTarget.startAnimation(this)
            }
//            AnimationUtils.loadAnimation(this, R.anim.rotate_anim).apply {
//                binding.tvAnimTarget.startAnimation(this)
//            }
        }
        binding.btTranslateAnim.setOnClickListener {
            TranslateAnimation(
                Animation.ABSOLUTE,
                0.0f,
                Animation.ABSOLUTE,
                100.0f,
                Animation.ABSOLUTE,
                0.0f,
                Animation.ABSOLUTE,
                100.0f
            ).apply {
                fillAfter = true
                duration = 800
                binding.tvAnimTarget.startAnimation(this)
            }
//            AnimationUtils.loadAnimation(this, R.anim.translate_anim).apply {
//                binding.tvAnimTarget.startAnimation(this)
//            }
        }
        binding.btSetAnim.setOnClickListener {
            AnimationSet(true).apply {
                addAnimation(
                    ScaleAnimation(
                        0.0f,
                        1.4f,
                        0.0f,
                        1.4f,
                        Animation.RELATIVE_TO_SELF,
                        0.5f,
                        Animation.RELATIVE_TO_SELF,
                        0.5f
                    )
                )
                addAnimation(
                    RotateAnimation(
                        0.0f,
                        90.0f,
                        Animation.RELATIVE_TO_SELF,
                        0.5f,
                        Animation.RELATIVE_TO_SELF,
                        0.5f
                    )
                )
                this.duration = 2000
                fillAfter = true
                binding.tvAnimTarget.startAnimation(this)
            }
//            AnimationUtils.loadAnimation(this, R.anim.set_anim).apply {
//                binding.tvAnimTarget.startAnimation(this)
//            }
        }
        /**
         * 扫描动画
         */
        val animation1 = AnimationUtils.loadAnimation(this, R.anim.scan_anim)
        val animation2 = AnimationUtils.loadAnimation(this, R.anim.scan_anim)
        val animation3 = AnimationUtils.loadAnimation(this, R.anim.scan_anim)
        val animation4 = AnimationUtils.loadAnimation(this, R.anim.scan_anim)
        binding.btSetAnimScan.setOnClickListener {
            binding.scanViewAll.ivCircle1.startAnimation(animation1)

            animation2.startOffset = 600
            binding.scanViewAll.ivCircle2.startAnimation(animation2)

            animation3.startOffset = 1200
            binding.scanViewAll.ivCircle3.startAnimation(animation3)

            animation4.startOffset = 1800
            binding.scanViewAll.ivCircle4.startAnimation(animation4)

        }

        /**
         * 帧动画实现播放动画
         */
        val playAnim = binding.ivPlayAnimList.drawable as AnimationDrawable
        playAnim.start()
    }

}