package com.example.gitretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewModelScope
import com.example.gitretrofit.network.ApiClient
import com.example.gitretrofit.network.response.GithubUser
import com.example.gitretrofit.util.NetworkResult
import com.example.gitretrofit.util.safeApiCall
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var apiClient: ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        runBlocking {
            getCountryWiseCases()
        }
    }

    suspend fun getCountryWiseCases(): NetworkResult<GithubUser> {
        var networkResult: NetworkResult<GithubUser>? = null

        safeApiCall( { apiClient.getUserInfo("Priyansh-Kedia") },
            { networkResult = it
            Log.d("tagg",it.data.profile_dp.toString())},
            { networkResult = it }
        )

        return networkResult!!
    }
}