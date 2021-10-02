package com.example.newsapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.NewsPojo
import com.example.newsapp.NewsRepository

class NewsViewModel(application: Application) : AndroidViewModel(application) {

private val mutableLiveData : MutableLiveData<NewsPojo> = MutableLiveData<NewsPojo>()
    private val newsRepository : NewsRepository = NewsRepository(getApplication())

    fun getNewsData(): MutableLiveData<NewsPojo> {
        return mutableLiveData
    }

    fun getNewsDataFromServer(q:String,from:String,sortBy:String,apiKey:String) {

        newsRepository.getNewsData(q,from,sortBy,apiKey,mutableLiveData)

    }

}