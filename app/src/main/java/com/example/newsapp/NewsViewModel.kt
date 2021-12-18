package com.example.newsapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.NewsRepository

class NewsViewModel(application: Application) : AndroidViewModel(application) {

private val mutableLiveData : MutableLiveData<NewsModel> = MutableLiveData<NewsModel>()
    private val newsRepository : NewsRepository = NewsRepository()

    fun getNewsData(): MutableLiveData<NewsModel> {
        return mutableLiveData
    }

    fun getNewsDataFromServer(q:String,from:String,to:String,sortBy:String,apiKey:String) {

        newsRepository.getNewsData(q,from,to,sortBy,apiKey,mutableLiveData)

    }

}