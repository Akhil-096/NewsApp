package com.example.newsapp

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

object DataBindingAdapterUtil {

    @JvmStatic
    @BindingAdapter("loadImageFromUrl")
    fun loadImageFromUrl(imageView: ImageView?, imageURL: String?) {

        Glide.with(imageView!!)
            .load(imageURL)
            .centerCrop()
            .into(imageView)
    }

}