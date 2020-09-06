package com.honaf.mvvm

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.honaf.mvvm.viewmodel.UserViewModel

class MainActivity1 : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userViewModel = ViewModelProvider(this).get(
            UserViewModel::class.java
        )
        userViewModel.userLiveData
            .observe(this, Observer { user -> Log.e("honaf", user.toString()) })
    }
}