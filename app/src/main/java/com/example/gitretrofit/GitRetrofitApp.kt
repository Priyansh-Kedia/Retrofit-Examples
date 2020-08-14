package com.example.gitretrofit

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GitRetrofitApp: Application() {


    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: GitRetrofitApp
        private set
    }
}