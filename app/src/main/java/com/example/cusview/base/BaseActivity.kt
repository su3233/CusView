package com.example.cusview.base

import android.R.id
import android.os.Bundle
import android.view.MenuItem
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
        supportActionBar?.title = this.componentName.className
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        init()
        initClick()
    }

    abstract fun initViewBinding(): T

    abstract fun init()
    abstract fun initClick()

    fun setTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            id.home -> finish()
            else -> {}
        }
        return true
    }

    fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

}