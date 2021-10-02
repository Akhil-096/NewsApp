package com.example.newsapp

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository {

    private val newsApi: NewsApi = RetrofitClient.createService(NewsApi::class.java)

    fun getNewsData(q:String, from:String,sortBy:String,apiKey:String, mutableLiveData : MutableLiveData<NewsModel> ) {
        newsApi.newsData(q, from, sortBy, apiKey)?.enqueue(object : Callback<NewsModel?> {

            override fun onResponse(call: Call<NewsModel?>?, response: Response<NewsModel?>?) {
                if(response?.body()?.status.equals("ok")){
                    Log.e("tag01", "onResponse: "+ response?.body()?.articles)
                }
                mutableLiveData.postValue(response?.body())
            }

            override fun onFailure(call: Call<NewsModel?>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }
}

