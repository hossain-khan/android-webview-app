package com.example.androidwebpp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.example.androidwebpp.webclient.AppWebViewClient
import com.example.androidwebpp.webclient.WebViewChromeClient

/**
 * Simple [WebView] based activity.
 *
 * Example code is taken from https://developer.android.com/develop/ui/views/layout/webapps/webview
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        val myWebView: WebView = findViewById(R.id.webview)
        myWebView.loadUrl("https://www.google.com")
        myWebView.settings.javaScriptEnabled = true

        myWebView.webViewClient = AppWebViewClient()
        myWebView.webChromeClient = WebViewChromeClient()
    }
}