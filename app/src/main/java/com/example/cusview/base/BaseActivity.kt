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
    companion object {
        var TAG: String = this.javaClass.name
    }

    lateinit var binding: T
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = initViewBinding()
        setContentView(binding.root)
        supportActionBar?.title = definiteTitle()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initData()
        initView()
        initClick()
    }

    open fun initView() {

    }

    abstract fun initViewBinding(): T

    abstract fun initData()
    abstract fun definiteTitle(): String
    abstract fun initClick()


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