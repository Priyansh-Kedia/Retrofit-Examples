package com.example.gitretrofit.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import com.example.gitretrofit.base.BaseActivity
import com.example.gitretrofit.R
import com.example.gitretrofit.network.ApiClient
import com.example.gitretrofit.network.response.GithubUser
import com.example.gitretrofit.util.NetworkResult
import com.example.gitretrofit.util.safeApiCall
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

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
        viewModel.userLiveData.observe(this) {
            Log.d("TAG!",it.toString())
        }
    }

    private fun makeApiCalls() {
        viewModel.getCountryWiseCases("Priyansh-Kedia")
    }

}