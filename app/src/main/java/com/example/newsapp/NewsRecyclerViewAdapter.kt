package com.example.newsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.NewsItemBinding

class NewsRecyclerViewAdapter(val context: Context, private  val articles: List<ArticlesItem?>?) : RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding : NewsItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.news_item,
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.newsItemBinding.articles = articles?.get(position)
        holder.newsItemBinding.title = articles?.get(position)?.title
        holder.newsItemBinding.desc = articles?.get(position)?.description
        holder.newsItemBinding.imageUrl = articles?.get(position)?.urlToImage
    }

    override fun getItemCount(): Int {
        return articles!!.size
    }

   inner class ViewHolder(itemView: NewsItemBinding) : RecyclerView.ViewHolder(itemView.root) {

        var newsItemBinding : NewsItemBinding

        init {
             newsItemBinding = itemView
             newsItemBinding.clickHandler = ClickHandler()
        }


}

    inner class ClickHandler{

        fun onArticleClick(view: View, articles:ArticlesItem){

            val i = Intent(context, WebActivity::class.java)
            i.putExtra("url", articles.url)
            context.startActivity(i)


            }

    }

}