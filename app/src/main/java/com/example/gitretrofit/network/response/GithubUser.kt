package com.example.gitretrofit.network.response

import com.google.gson.annotations.SerializedName

data class GithubUser(

    @SerializedName("avatar_url")
    val profile_dp: String?

)