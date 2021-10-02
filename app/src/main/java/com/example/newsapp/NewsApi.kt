package com.example.newsapp

import com.example.newsapp.NewsPojo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    fun newsData(@Query("q") q:String,@Query("from") from:String,@Query("sortBy") sortBy:String,@Query("apiKey") apiKey:String): Call<NewsPojo?>?

}
