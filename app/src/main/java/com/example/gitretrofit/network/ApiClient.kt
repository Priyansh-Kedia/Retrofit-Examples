package com.example.gitretrofit.network

import com.example.gitretrofit.network.response.GithubUser
import retrofit2.http.GET
import retrofit2.http.Path

@JvmSuppressWildcards
interface ApiClient {

    @GET("users/{user}")
    suspend fun getUserInfo(@Path("user") user: String): GithubUser

}