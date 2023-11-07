package com.example.cusview.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 *@autor sts
 *@date 2023/11/7 23:50
 *@description
 */
abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {
    lateinit var binding: T
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = initViewBinding()
        setContentView(binding.root)
        init()
        initClick()
    }

    abstract fun initViewBinding(): T

    abstract fun init()
    abstract fun initClick()

    fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

}