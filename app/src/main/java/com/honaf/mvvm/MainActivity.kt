package com.honaf.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.honaf.mvvm.model.User
import com.honaf.mvvm.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userViewModel :UserViewModel = ViewModelProvider(this).get(UserViewModel::class.java);
        userViewModel.userLiveData.observe(this,
            Observer<User> { t ->
                /**
                 * Called when the data is changed.
                 * @param t  The new data
                 */
                /**
                 * Called when the data is changed.
                 * @param t  The new data
                 */
                Log.e("honaf",t.toString())
            })
    }
}
