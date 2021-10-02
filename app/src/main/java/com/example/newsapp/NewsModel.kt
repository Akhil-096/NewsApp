package com.example.newsapp

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NewsPojo(

	@field:SerializedName("totalResults")
	@Expose
	val totalResults: Int? = null,

	@field:SerializedName("articles")
	@Expose
	val articles: List<ArticlesItem?>? = null,

	@field:SerializedName("status")
	@Expose
	val status: String? = null
)

data class ArticlesItem(

	@field:SerializedName("publishedAt")
	@Expose
	val publishedAt: String? = null,

	@field:SerializedName("author")
	@Expose
	val author: String? = null,

	@field:SerializedName("urlToImage")
	@Expose
	val urlToImage: String? = null,

	@field:SerializedName("description")
	@Expose
	val description: String? = null,

	@field:SerializedName("source")
	@Expose
	val source: Source? = null,

	@field:SerializedName("title")
	@Expose
	val title: String? = null,

	@field:SerializedName("url")
	@Expose
	val url: String? = null,

	@field:SerializedName("content")
	@Expose
	val content: String? = null
)

data class Source(

	@field:SerializedName("name")
	@Expose
	val name: String? = null,

	@field:SerializedName("id")
	@Expose
	val id: String? = null
)
