package com.example.gitretrofit.util

import android.content.Context
import android.util.Log
import android.widget.Toast

fun log(message: String) {
    Log.d("TAG!!!!",message)
}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}