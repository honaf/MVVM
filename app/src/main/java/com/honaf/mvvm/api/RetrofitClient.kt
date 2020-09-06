package com.honaf.mvvm.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor() {
    private val retrofit: Retrofit

    fun getApi() :Api{
        return retrofit.create(Api::class.java)
    }
    companion object {
        private const val BASE_URL = "https://github.com/"
        private var retrofitClient: RetrofitClient? = null
        @get:Synchronized
        val instance: RetrofitClient?
            get() {
                if (retrofitClient == null) {
                    retrofitClient = RetrofitClient()
                }
                return retrofitClient
            }
    }

    init {
        retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}