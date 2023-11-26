package com.example.cusview.views.capture2_animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.example.cusview.R
import com.example.cusview.base.BaseActivity
import com.example.cusview.databinding.ActivityAnimationctivityBinding

/**
 *@autor sts
 *@date 2023/11/26 14:42
 *@description 动画
 * android动画分为view动画（又分为tween动画<补间动画>和frame动画<帧动画>）和property动画（又分为value动画和object动画）
 */
class AnimationActivity : BaseActivity<ActivityAnimationctivityBinding>() {
    override fun initViewBinding() = ActivityAnimationctivityBinding.inflate(layoutInflater)

    override fun init() {
        setTitle("动画")
        /**
         * 动画类型分为alpha、scale、translate、rotate、set（动画集）
         */
    }

    override fun initClick() {
        binding.btScaleAnim.setOnClickListener {
            AnimationUtils.loadAnimation(this, R.anim.scale_anim).apply {
                binding.tvAnimTarget.startAnimation(this)
            }
        }
        binding.btAlphaAnim.setOnClickListener {
            AnimationUtils.loadAnimation(this, R.anim.alpha_anim).apply {
                binding.tvAnimTarget.startAnimation(this)
            }
        }
        binding.btRoateAnim.setOnClickListener {
            AnimationUtils.loadAnimation(this, R.anim.rotate_anim).apply {
                binding.tvAnimTarget.startAnimation(this)
            }
        }
        binding.btTranslateAnim.setOnClickListener {
            AnimationUtils.loadAnimation(this, R.anim.translate_anim).apply {
                binding.tvAnimTarget.startAnimation(this)
            }
        }
        binding.btSetAnim.setOnClickListener {
            AnimationUtils.loadAnimation(this, R.anim.set_anim).apply {
                binding.tvAnimTarget.startAnimation(this)
            }
        }
    }

}