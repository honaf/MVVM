package com.honaf.mvvm.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.honaf.mvvm.api.Api
import com.honaf.mvvm.db.UserDao
import com.honaf.mvvm.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(private val userDao: UserDao, private val api: Api) {
    private val TAG = this.javaClass.name
    fun getUser(name: String?): LiveData<User?>? {
        refresh(name)
        return userDao.getUserByName(name)
    }

    fun refresh(userName: String?) {
        api.getUser(userName)!!.enqueue(object : Callback<User?> {
            override fun onResponse(
                call: Call<User?>,
                response: Response<User?>
            ) {
                if (response.body() != null) {
                    insertUser(response.body())
                }
            }

            override fun onFailure(
                call: Call<User?>,
                t: Throwable
            ) {
            }
        })
    }

    private fun insertUser(user: User?) {
        AsyncTask.execute { userDao.insertUser(user) }
    }

}