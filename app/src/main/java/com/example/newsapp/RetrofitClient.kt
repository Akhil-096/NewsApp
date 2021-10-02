package com.example.newsapp

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
            )
        )
        .client(
            OkHttpClient.Builder().retryOnConnectionFailure(true)
                .readTimeout(30000, TimeUnit.MILLISECONDS)
                .writeTimeout(30000, TimeUnit.MILLISECONDS)
                .connectTimeout(30000, TimeUnit.MILLISECONDS)
                .build()
        )
        .build()

    fun <T> createService(serviceClass: Class<T>?): T {
        return retrofit.create(serviceClass)
    }
}