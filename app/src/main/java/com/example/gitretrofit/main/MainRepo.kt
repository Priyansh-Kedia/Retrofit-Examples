package com.example.gitretrofit.main

import com.example.gitretrofit.network.ApiClient
import com.example.gitretrofit.network.response.GithubUser
import com.example.gitretrofit.util.NetworkResult
import com.example.gitretrofit.util.safeApiCall
import javax.inject.Inject

class MainRepo @Inject constructor(private val apiClient: ApiClient) {

    suspend fun getCountryWiseCases(user: String): NetworkResult<GithubUser> {
        var networkResult: NetworkResult<GithubUser>? = null

        safeApiCall({
            apiClient.getUserInfo(user)},
            { networkResult = it },
            { networkResult = it }
        )

        return networkResult!!
    }

}