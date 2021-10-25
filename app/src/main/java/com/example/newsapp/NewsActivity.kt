package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.NewsActivityBinding

class NewsActivity : AppCompatActivity() {

    private lateinit var binding: NewsActivityBinding
    private lateinit var recyclerView : RecyclerView
    private lateinit var newsViewModel : NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.news_activity)
        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        newsViewModel.getNewsDataFromServer("apple", "2021-10-24","publishedAt", "7df876678d8c4bc8b77a2ba0d885bd53")
        recyclerView = binding.recyclerView
        observeLiveData()

    }

    fun observeLiveData(){


        newsViewModel.getNewsData().observe(this, Observer {

            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = NewsRecyclerViewAdapter(this, it.articles)


        })

    }

}
