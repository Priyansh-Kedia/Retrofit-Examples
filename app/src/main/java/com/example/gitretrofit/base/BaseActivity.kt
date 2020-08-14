package com.example.gitretrofit.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gitretrofit.di.ViewModelFactory
import com.example.gitretrofit.network.ApiClient
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
abstract class BaseActivity: AppCompatActivity() {

    @Inject
    lateinit var apiClient: ApiClient

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}