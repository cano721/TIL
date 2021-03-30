package com.example.permissionpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import kotlinx.android.synthetic.main.basic_permission_test.*

class BasicPermissionTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.basic_permission_test)

        val settings = webview.settings // webSettings타입
        settings.javaScriptEnabled = true
        settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK

        webview.loadUrl("https://m.daum.net")
    }
}