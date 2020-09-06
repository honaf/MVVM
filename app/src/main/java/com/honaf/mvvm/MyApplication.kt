package com.honaf.mvvm

import android.app.Application
import com.honaf.mvvm.api.Api
import com.honaf.mvvm.api.RetrofitClient.Companion.instance
import com.honaf.mvvm.db.UserDatabase
import com.honaf.mvvm.db.UserDatabase.Companion.getInstance

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        userDatabase = getInstance(this)
        api = instance!!.getApi()
    }

    companion object {
        var userDatabase: UserDatabase? = null
            private set
        var api: Api? = null
            private set

    }
}