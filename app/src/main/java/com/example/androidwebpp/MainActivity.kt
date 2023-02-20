package com.example.androidwebpp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView
import com.example.androidwebpp.webclient.AppWebViewClient
import com.example.androidwebpp.webclient.WebViewChromeClient

/**
 * Simple [WebView] based activity.
 *
 * Example code is taken from https://developer.android.com/develop/ui/views/layout/webapps/webview
 */
class MainActivity : AppCompatActivity() {
    private lateinit var myWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        myWebView = findViewById(R.id.webview)
        myWebView.loadUrl("https://www.google.com")
        myWebView.settings.javaScriptEnabled = true

        myWebView.webViewClient = AppWebViewClient()
        myWebView.webChromeClient = WebViewChromeClient()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && myWebView.canGoBack()) {
            myWebView.goBack()
            return true
        }
        // If it wasn't the Back key or there's no webpage history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event)
    }
}