package com.example.newsapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import com.example.newsapp.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {

    lateinit var webBinding: ActivityWebBinding
    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        webBinding = DataBindingUtil.setContentView(this, R.layout.activity_web)
        webView = webBinding.webView

        webView.settings.setJavaScriptEnabled(true)

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url.toString())
                return true
            }
        }
        webView.loadUrl(intent.getStringExtra("url").toString())
    }


}