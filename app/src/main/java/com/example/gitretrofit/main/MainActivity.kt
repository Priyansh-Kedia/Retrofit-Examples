package com.example.gitretrofit.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.observe
import com.example.gitretrofit.R
import com.example.gitretrofit.base.BaseActivity
import com.example.gitretrofit.util.log

class MainActivity : BaseActivity() {

    private val viewModel by viewModels<MainViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        makeApiCalls()
        setObserver()
    }

    private fun setObserver() {
        viewModel.userLiveData.observe(this) { user ->
            log("Github user: $user")
        }
    }

    private fun makeApiCalls() {
        viewModel.getHithubUserInfo("Priyansh-Kedia")
    }

}