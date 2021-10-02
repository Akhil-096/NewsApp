package com.example.newsapp

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository(context: Context) {

    private val newsApi: NewsApi = RetrofitClient.createService(NewsApi::class.java)

    fun getNewsData(q:String, from:String,sortBy:String,apiKey:String, mutableLiveData : MutableLiveData<NewsPojo> ) {
        newsApi.newsData(q, from, sortBy, apiKey)?.enqueue(object : Callback<NewsPojo?> {

            override fun onResponse(call: Call<NewsPojo?>?, response: Response<NewsPojo?>?) {
                if(response?.body()?.status.equals("ok")){
                    Log.e("tag01", "onResponse: "+ response?.body()?.articles)
                }
                mutableLiveData.postValue(response?.body())
            }

            override fun onFailure(call: Call<NewsPojo?>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }
}

