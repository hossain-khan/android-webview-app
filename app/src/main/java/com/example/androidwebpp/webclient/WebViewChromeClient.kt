package com.example.androidwebpp.webclient

import android.util.Log
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient

class WebViewChromeClient : WebChromeClient() {
    companion object {
        private const val LOG_TAG = "WebViewChromeClient"
    }

    override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
        Log.d(LOG_TAG, "onConsoleMessage: $consoleMessage")
        return true // disable console message on logcat
    }
}
