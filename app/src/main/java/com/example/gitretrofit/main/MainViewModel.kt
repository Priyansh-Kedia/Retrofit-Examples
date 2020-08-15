package com.example.gitretrofit.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.example.gitretrofit.network.response.GithubUser
import com.example.gitretrofit.util.NetworkResult
import com.example.gitretrofit.util.log
import kotlinx.coroutines.launch

class MainViewModel @Inject constructor(private val repo: MainRepo): ViewModel() {

    private val _userLiveData = MutableLiveData<GithubUser>()
    val userLiveData: LiveData<GithubUser>
        get() = _userLiveData

    fun getHithubUserInfo(user: String) {
       viewModelScope.launch {
           val response = repo.getGithubUserInfo(user)

           when(response) {
               is NetworkResult.Success -> {
                   val data = response.data
                   _userLiveData.value = data
               }

               is NetworkResult.Error -> {
                   val data = response.exception
                   log(data.toString())
               }
           }
       }
    }

}